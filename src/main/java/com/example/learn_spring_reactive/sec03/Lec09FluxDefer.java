package com.example.learn_spring_reactive.sec03;

import com.example.learn_spring_reactive.comman.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec09FluxDefer {


    // delay execution
    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c");

        Flux.fromIterable(list);

        Flux.defer(() -> Flux.fromIterable(list)).subscribe(Util.subscriber());

    }
}
