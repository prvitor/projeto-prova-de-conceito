package com.study.studyingwebclients.client;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class TestResponsesClient {

    WebClient webClient = WebClient.create("http://localhost:8081");

    public Mono<Long> getTestResponseOne() {

        return webClient.get()
                .uri("/test-responses/one")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Long.class);
    }

    public Mono<Long> getTestResponseTwo() {

        return webClient.get()
                .uri("/test-responses/two")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Long.class);
    }
}
