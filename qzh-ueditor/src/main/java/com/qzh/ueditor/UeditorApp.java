package com.qzh.ueditor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient       //服务发现
public class UeditorApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(UeditorApp.class);
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(UeditorApp.class);
        application.run(args);
        LOGGER.info("Ueditor application started!!!");
    }
}
