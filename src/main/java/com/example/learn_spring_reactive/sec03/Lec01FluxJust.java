package com.example.learn_spring_reactive.sec03;

import com.example.learn_spring_reactive.comman.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxJust {

    public static void main(String[] args) {

        Flux.just(1)
                .subscribe(Util.subscriber());


        Flux.just(1,2,3,"gurjot")
                .subscribe(Util.subscriber());
    }
}
