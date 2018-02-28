package com.qzh.search.handler;

import com.huidong.qzh.util.common.pojo.ProductSearchDTO;
import com.qzh.search.service.ProductService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "newProductRecord")
public class InsertProductHandler {

    @Autowired
    private ProductService productService;

    @RabbitHandler
    public void handInsertProductEvent(ProductSearchDTO productSearchDTO) {
        productService.insertProductRecord(productSearchDTO);
    }
}
