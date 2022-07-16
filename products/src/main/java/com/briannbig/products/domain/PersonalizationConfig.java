package com.briannbig.products.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PersonalizationConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
