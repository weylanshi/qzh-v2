package com.huidong.qzh.standard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //开启事务
@MapperScan("com.huidong.qzh.standard.mapper")
@EnableDiscoveryClient       //服务发现
@EnableFeignClients
public class StandardApp {
    public static void main(String[] args) {
        SpringApplication.run(StandardApp.class,args);
    }
}
