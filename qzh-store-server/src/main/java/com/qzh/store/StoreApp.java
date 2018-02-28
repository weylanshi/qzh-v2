package com.qzh.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //开启事务
//@EnableDiscoveryClient       //服务发现
@MapperScan("com.qzh.store.mapper")
@EnableFeignClients
public class StoreApp {
    public static void main(String[] args) {
        SpringApplication.run(StoreApp.class,args);
    }
}
