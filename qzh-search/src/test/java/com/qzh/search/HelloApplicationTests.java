package com.qzh.search;

import com.huidong.qzh.util.common.pojo.ProductSearchDTO;
import com.qzh.search.eventcenter.InsertProductEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SearchApp.class)
public class HelloApplicationTests {

    @Autowired
    private InsertProductEvent insertProductEvent;


    @Test
    public void insertProduct() {
        ProductSearchDTO productSearchDTO = null;
        for (int i = 0; i < 10; i++) {
            productSearchDTO = new ProductSearchDTO();
            productSearchDTO.setProductGoodsId(1 + i);
            productSearchDTO.setProductName("白卡纸");
            productSearchDTO.setOriginalPrice(new BigDecimal(10 + i));
            productSearchDTO.setPromotionPrice(new BigDecimal(9 + i));
            productSearchDTO.setSalesVolume(1000 + i);
            productSearchDTO.setPicturePath("http://m.sceo360.com/product/product_30/img/9590e0dd430c428ab9ace04bd68a7f64.jpg");
            productSearchDTO.setSelfSupport(1);
            productSearchDTO.setEipMemberId(1 + i);
            productSearchDTO.setEipMemberName("张三" + i + "的自营店");
            insertProductEvent.sendInsertProductEvent(productSearchDTO);
        }

    }

}
