package com.study.testresponses.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@RestController
public class TestResponsesController {

    @GetMapping("/test-responses/one")
    public Long testResponseOne() throws InterruptedException {
        Long result = Long.valueOf(111L + LocalTime.now().getSecond());
        Thread.sleep(1000);
        System.out.println("Response one!");
        return result;
    }

    @GetMapping("/test-responses/two")
    public Long testResponseTwo() throws InterruptedException {
        Long result = Long.valueOf(111L + LocalTime.now().getSecond());
        Thread.sleep(1000);
        System.out.println("Response two!");
        return result;
    }

}
