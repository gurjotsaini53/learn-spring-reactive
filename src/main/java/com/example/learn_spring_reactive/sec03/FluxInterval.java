package com.example.learn_spring_reactive.sec03;

import com.example.learn_spring_reactive.comman.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxInterval {

    public static void main(String[] args) {

        Flux.interval(Duration.ofMillis(500)).subscribe(Util.subscriber());


        Flux.interval(Duration.ofMillis(500))
                .map(i -> Util.getFaker().name().firstName())
                        .subscribe(Util.subscriber());

        Util.putThreadOnSleep(5);
    }
}
