package com.study.studyingwebclients.controller;

import com.study.studyingwebclients.client.TestResponsesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

    @Autowired
    private TestResponsesClient client;

    @GetMapping("/fast-test")
    public Object fastTest() {

        Mono<Long> one = client.getTestResponseOne();
        Mono<Long> two = client.getTestResponseTwo();

        return Mono.zip(one, two).map(tuple -> {
            Long one1 = tuple.getT1();
            Long two2 = tuple.getT2();
            return one1 + " " + two2;
        });
    }

    @GetMapping("/slow-test")
    public Object slowTest() {

        Long one = client.getTestResponseOne().block();
        Long two = client.getTestResponseTwo().block();

        return one + " " + two;
    }
}
