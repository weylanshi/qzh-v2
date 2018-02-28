package com.huidong.qzh.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@MapperScan("com.huidong.qzh.sso.mapper")
@EnableCircuitBreaker
@EnableDiscoveryClient
public class SsoApp {

    public static void main(String[] args) {
        SpringApplication.run(SsoApp.class,args);
    }
}
