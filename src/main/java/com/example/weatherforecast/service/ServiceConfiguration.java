package com.example.weatherforecast.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// 演習4-1 Java Configファイルの設定をしよう
@Configuration
public class ServiceConfiguration {

    // 演習4-2 RestTemplateのBean定義をしよう
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
