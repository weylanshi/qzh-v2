package com.qzh.search.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qzh.search.model.Book;
import com.qzh.search.service.BookService;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private TransportClient client;


    public void insertBook() {
        Book book = new Book();
        book.setAuthor("weyne");
        book.setReleaseDate("2018-1-2");
        book.setTitle("Oracle");
        book.setId("2");
        String json = JSONObject.toJSONString(book);
        IndexResponse response = client.prepareIndex("book", "book").setSource(json, XContentType.JSON).get();
        String index = response.getIndex();
        System.out.println("index :" + index);
        String type = response.getType();
        System.out.println("type :" + type);
        String id = response.getId();
        System.out.println("id :" + id);
        long version = response.getVersion();
        System.out.println("version :" + version);
        RestStatus status = response.status();
        System.out.println("status :" + status);

    }

    @Override
    public Book getBookById(String id) {
        GetResponse response = client.prepareGet("book", "book", id).get();
        Map<String, Object> source = response.getSource();
        source.forEach((k, v) -> {
            System.out.println(k + " :" + v);
        });
        return null;
    }

    public void search() {

        SearchResponse response = client.prepareSearch("book")
                .setTypes("book")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery("author", "weylan"))
                .get();
        SearchHits hits = response.getHits();
        hits.forEach(hit -> {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            System.out.println(sourceAsMap);

        });


    }
}
