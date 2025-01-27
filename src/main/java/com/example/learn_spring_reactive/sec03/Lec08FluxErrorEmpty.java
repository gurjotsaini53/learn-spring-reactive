package com.example.learn_spring_reactive.sec03;

import com.example.learn_spring_reactive.comman.Util;
import reactor.core.publisher.Flux;

public class Lec08FluxErrorEmpty {
    public static void main(String[] args) {

        Flux.empty().subscribe(Util.subscriber());


        Flux.error(new RuntimeException("Error ")).subscribe(Util.subscriber());
    }
}
