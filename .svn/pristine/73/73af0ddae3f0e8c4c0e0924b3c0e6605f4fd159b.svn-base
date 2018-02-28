package com.huidong.qzh.market;/*
 * @Author: xingyibiao
 * @Date:    2017/12/22 14:05
 * @Last Modified by:   weylan
 * @Last Modified time:  2017/12/22 14:05
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //开启事务
@MapperScan("com.huidong.qzh.market.mapper")
@EnableDiscoveryClient
public class MarketApp {
    public static void main(String[] args) {

        SpringApplication.run(MarketApp.class,args);
    }
}
