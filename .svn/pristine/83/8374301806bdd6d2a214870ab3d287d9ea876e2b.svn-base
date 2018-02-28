package com.huidong.qzh.standard.eventcenter;

import com.huidong.qzh.util.common.pojo.ProductSearchDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class InsertProductEvent {

    @Resource
    private AmqpTemplate rabbitTemplate;

    public void sendInsertProductEvent(ProductSearchDTO productSearchDTO){
        this.rabbitTemplate.convertAndSend("newProductRecord",productSearchDTO);
    }
}
