package com.qzh.search.service;

import com.huidong.qzh.util.common.pojo.ProductSearchDTO;
import com.huidong.qzh.util.common.util.QzhPageResult;
import org.elasticsearch.rest.RestStatus;

public interface ProductService {

    RestStatus insertProductRecord(ProductSearchDTO productSearchDTO);

    boolean delIndex();

    QzhPageResult search(String q, Integer pageNo, Integer pageSize);
}
