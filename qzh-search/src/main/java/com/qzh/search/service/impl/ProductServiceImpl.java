package com.qzh.search.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.huidong.qzh.util.common.pojo.ProductSearchDTO;
import com.huidong.qzh.util.common.util.QzhPageResult;
import com.huidong.qzh.util.common.util.QzhPageResultWithOptions;
import com.huidong.qzh.util.common.util.StringUtils;
import com.qzh.search.service.ProductService;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AbstractAggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final String PRODUCT_INDEX = "product";
    private final String PRODUCT_TYPE = "product";

    @Autowired
    private TransportClient client;

    public RestStatus insertProductRecord(ProductSearchDTO productSearchDTO) {
        String json = JSONObject.toJSONString(productSearchDTO);
        IndexResponse indexResponse = client.prepareIndex(PRODUCT_INDEX, PRODUCT_TYPE, productSearchDTO.getProductGoodsId().toString()).setSource(json, XContentType.JSON).get();
        return indexResponse.status();
    }

    @Override
    public boolean delIndex() {
        DeleteIndexResponse response = client.admin().indices().prepareDelete(PRODUCT_INDEX).execute().actionGet();
        return response.isAcknowledged();
    }

    @Override
    public QzhPageResult search(String q, Integer pageNo, Integer pageSize, Integer order,
                                Integer shopId, String brand, String specOptionName, String customCategoryId) {
        // 创建查询索引,参数productindex表示要查询的索引库为productindex
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(PRODUCT_INDEX);
        // 设置查询索引类型
        searchRequestBuilder.setTypes(PRODUCT_TYPE);
        // 设置查询类型 1.SearchType.DFS_QUERY_THEN_FETCH = 精确查询 2.SearchType.SCAN
        // = 扫描查询,无序
        searchRequestBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);

        // 设置查询关键词
        BoolQueryBuilder bq = QueryBuilders.boolQuery();
        if (!StringUtils.equalsNull(q)) {
            QueryStringQueryBuilder q1 = new QueryStringQueryBuilder(q);
//        queryBuilder.analyzer("ik_max_word");
            q1.field("productName");
            bq.should(q1);
        }
        if (shopId != null) {
            TermQueryBuilder q2 = QueryBuilders.termQuery("eipMemberId", shopId);
            bq.must(q2);
        }
        if (order != null && order == 5) {
            TermQueryBuilder q3 = QueryBuilders.termQuery("isNew", 1);
            bq.must(q3);
        }
        if (org.apache.commons.lang.StringUtils.isNotBlank(brand)) {
            TermQueryBuilder q4 = QueryBuilders.termQuery("brand", brand);
//            bq.must(q4);
            bq.should(q4);
        }
        if (org.apache.commons.lang.StringUtils.isNotBlank(specOptionName)) {
            TermQueryBuilder q5 = QueryBuilders.termQuery("specOptionName", specOptionName);
            bq.should(q5);
        }
        if (org.apache.commons.lang.StringUtils.isNotBlank(customCategoryId)) {
            TermQueryBuilder q5 = QueryBuilders.termQuery("customCategoryId", customCategoryId);
            bq.must(q5);
        }

        searchRequestBuilder.setQuery(bq);
        // 分页
        searchRequestBuilder.setFrom((pageNo - 1) * pageSize).setSize(pageSize);

        // 设置是否按查询匹配度排序
        searchRequestBuilder.setExplain(true);
        // 按照字段排序
        if (order != null) {
            switch (order) {
                case 2://
                    searchRequestBuilder.addSort("salesVolume", SortOrder.DESC);
                    break;
                case 3://价格递增
                    searchRequestBuilder.addSort("originalPrice", SortOrder.ASC);
                    break;
                case 4:////价格递减
                    searchRequestBuilder.addSort("originalPrice", SortOrder.DESC);
                    break;
                default:
                    searchRequestBuilder.addSort("clickVolume", SortOrder.DESC);
                    searchRequestBuilder.addSort("updateTime", SortOrder.DESC);
                    break;
            }
        }

        // 设置高亮显示
        HighlightBuilder hiBuilder = new HighlightBuilder();
        hiBuilder.preTags("<span style='color:red'>");
        hiBuilder.postTags("</span>");
        hiBuilder.field("productName");
        searchRequestBuilder.highlighter(hiBuilder);
        //添加统计
        AbstractAggregationBuilder aggregation = AggregationBuilders.terms("categoryId_count").field("categoryId");
        searchRequestBuilder.addAggregation(aggregation);
        // 执行搜索,返回搜索响应信息
        SearchResponse response = searchRequestBuilder.execute().actionGet();

        //获取查询结果集
        SearchHits searchHits = response.getHits();
        List<ProductSearchDTO> resultList = new ArrayList<>();
        //遍历结果
        for (SearchHit hit : searchHits) {
            ProductSearchDTO productSearchDTO = JSONObject.parseObject(hit.getSourceAsString(), ProductSearchDTO.class);
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            if (highlightFields.size() > 0) {
                Text[] text = highlightFields.get("productName").getFragments();
                if (text != null && text.length > 0) {
                    productSearchDTO.setProductName(text[0].string());
                }
            }
            resultList.add(productSearchDTO);
        }
        Terms terms = response.getAggregations().get("categoryId_count");
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        if (buckets != null && buckets.size() > 0) {
            Long max = buckets.stream().mapToLong(Terms.Bucket::getDocCount).max().getAsLong();
            List<? extends Terms.Bucket> maxList = buckets.stream().filter(b -> b.getDocCount() == max).collect(Collectors.toList());
            Terms.Bucket bucket = maxList.get(0);
            HashMap<String, Object> options = new HashMap<>();
            options.put("categoryId", bucket.getKey());
            return QzhPageResultWithOptions.build(pageNo, pageSize, (searchHits.getTotalHits() + pageSize - 1) / pageSize, resultList, options);
        }

        return QzhPageResult.build(pageNo, pageSize, (searchHits.getTotalHits() + pageSize - 1) / pageSize, resultList);
    }


}
