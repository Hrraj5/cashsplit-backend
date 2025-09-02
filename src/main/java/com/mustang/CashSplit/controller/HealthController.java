package com.mustang.CashSplit.controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class HealthController {

    @QueryMapping
    public Mono<String> health(){
        return Mono.just("Ok");
    }
}
