package com.qzh.search.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.huidong.qzh.util.common.pojo.ProductSearchDTO;
import com.huidong.qzh.util.common.util.QzhPageResult;
import com.qzh.search.service.ProductService;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public QzhPageResult search(String q, Integer pageNo, Integer pageSize) {
        // 创建查询索引,参数productindex表示要查询的索引库为productindex
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(PRODUCT_INDEX);
        // 设置查询索引类型
        searchRequestBuilder.setTypes(PRODUCT_TYPE);
        // 设置查询类型 1.SearchType.DFS_QUERY_THEN_FETCH = 精确查询 2.SearchType.SCAN
        // = 扫描查询,无序
        searchRequestBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);

        // 设置查询关键词
        QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder(q);
        queryBuilder.analyzer("ik_max_word");
        queryBuilder.field("productName");
        searchRequestBuilder.setQuery(queryBuilder);

        // 分页应用q
        searchRequestBuilder.setFrom((pageNo - 1) * pageSize).setSize(pageSize);

        // 设置是否按查询匹配度排序
        searchRequestBuilder.setExplain(true);
        // 按照字段排序
//        searchRequestBuilder.addSort("publish_time", SortOrder.DESC);
        // 设置高亮显示

        HighlightBuilder hiBuilder = new HighlightBuilder();
        hiBuilder.preTags("<span style='color:red'>");
        hiBuilder.postTags("</span>");
        hiBuilder.field("productName");
        searchRequestBuilder.highlighter(hiBuilder);
        // 执行搜索,返回搜索响应信息
        SearchResponse response = searchRequestBuilder.execute().actionGet();

        //获取查询结果集
        SearchHits searchHits = response.getHits();
        List<ProductSearchDTO> resultList = new ArrayList<>();
        //遍历结果
        for (SearchHit hit : searchHits) {
            ProductSearchDTO productSearchDTO = JSONObject.parseObject(hit.getSourceAsString(), ProductSearchDTO.class);
            Text[] text = hit.getHighlightFields().get("productName").getFragments();
            if (text != null && text.length > 0) {
                productSearchDTO.setProductName(text[0].string());
            }
            resultList.add(productSearchDTO);
        }
        return QzhPageResult.build(pageNo, pageSize, (searchHits.getTotalHits() + pageSize - 1) / pageSize, resultList);
    }


}
