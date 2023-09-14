package com.example.spring_webclient.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebClientService {
    private final WebClient webClient;

    @Autowired
    public WebClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.escuelajs.co").build();
    }

    public Mono<String> fetchData() {
        return webClient
                .get()
                .uri("/api/v1/products")
                .retrieve()
                .bodyToMono(String.class);
    }
}
