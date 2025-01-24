package com.example.learn_spring_reactive.sec02;

import com.example.learn_spring_reactive.comman.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyError {

    // it is not necessary that mono always emits data

    public static void main(String[] args) {

        getUsername(1).subscribe(Util.subscriber());
        getUsername(2).subscribe(Util.subscriber());
        getUsername(3).subscribe(Util.subscriber());
    }

    public static Mono getUsername(int id)
    {
        switch (id)
        {
            case 1: return Mono.just("Gurjot");
            case 2: return Mono.empty(); // null
            default: return Mono.error(new RuntimeException("Invalid input"));

        }
    }
}
