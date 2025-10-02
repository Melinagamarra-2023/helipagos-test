package com.melinagamarra.paymentrequests.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${helipagos.api.url}")
    private String apiUrl;

    @Value("${helipagos.api.token}")
    private String apiToken;

    @Bean
    public WebClient helipagosWebClient ( WebClient.Builder builder){
        return builder
                .baseUrl(apiUrl)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiToken)
                .build();
    }
}
