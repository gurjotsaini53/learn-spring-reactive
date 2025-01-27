package com.example.learn_spring_reactive.sec02.client;

import com.example.learn_spring_reactive.comman.AbstractHttpClient;
import com.example.learn_spring_reactive.comman.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ExternalServiceClient extends AbstractHttpClient {
    public Mono<String> getProductName(int productId)
    {
        return this.httpClient.get()
                .uri("/demo01/product/" + productId)
                .responseContent()
                .asString()
                .next();
    }

    public Flux<String> getNames()
    {
        return this.httpClient.get()
                .uri("/demo01/name/stream")
                .responseContent()
                .asString();

    }
}
