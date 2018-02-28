package com.qzh.personalCenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //开启事务
@MapperScan("com.qzh.personalCenter.mapper")
@EnableDiscoveryClient       //服务发现
@EnableFeignClients
public class PersonalCenterApp {

    public static void main(String[] args) {
        SpringApplication.run(PersonalCenterApp.class,args);
    }
}
