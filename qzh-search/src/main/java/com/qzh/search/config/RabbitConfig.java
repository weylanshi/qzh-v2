package com.qzh.search.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {


    @Bean
    public Queue newProductQueue() {
        return new Queue("newProductRecord");
    }
}
