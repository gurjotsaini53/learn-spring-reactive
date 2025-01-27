package com.example.learn_spring_reactive.sec03;

import com.example.learn_spring_reactive.comman.Util;
import reactor.core.publisher.Flux;

public class Lec03Log {

    public static void main(String[] args) {


        // use for debugging purpose

        Flux.range(1,5)
                .log()
                .subscribe(Util.subscriber());


        Flux.range(1,5)
                .log()
                .map(i -> Util.getFaker().name())
                .log()
                .subscribe(Util.subscriber());
    }
}
