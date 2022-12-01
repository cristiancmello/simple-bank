package com.simplebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrentAccountServiceClient {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
            .rootUri("http://localhost:8089")
            .build();
    }
}
