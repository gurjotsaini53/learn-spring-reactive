package com.example.learn_spring_reactive.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec05onErrorDroppedProblem {

    private final static Logger log = LoggerFactory.getLogger(Lec05onErrorDroppedProblem.class);


    // Emitting empty Error

    public static void main(String[] args) {


        // this will give an err
//        getUsername(3).subscribe(
//                s -> System.out.println(s)
//        );

        // this will not give any error because we have dropped error here
        getUsername(3).subscribe(s -> System.out.println(s),err ->{});

    }

    public static Mono getUsername(int id) {
        switch (id) {
            case 1:
                return Mono.just("Gurjot");
            case 2:
                return Mono.empty(); // null
            default:
                return Mono.error(new RuntimeException("Invalid input"));

        }
    }
}
