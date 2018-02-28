package com.qzh.balance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class LoadBalanceApp {
    public static void main(String[] args) {
        SpringApplication.run(LoadBalanceApp.class, args);
    }
}
