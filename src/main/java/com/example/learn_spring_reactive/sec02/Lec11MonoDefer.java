package com.example.learn_spring_reactive.sec02;

import com.example.learn_spring_reactive.comman.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.rmi.server.UID;
import java.util.List;

public class Lec11MonoDefer {

    /*
     *
     *  to delay the publisher creation
     * */

    private final static Logger log = LoggerFactory.getLogger(Lec11MonoDefer.class);


    public static void main(String[] args) {


        // it will be creating publisher immediately, does not matter weather we have a subsciber or not
//        createPublisher();


        // will not create any publisher as there is no subscriber
        Mono.defer(()->createPublisher());



        Mono.defer(()->createPublisher()).subscribe(Util.subscriber());
    }


    private static Mono<Integer> createPublisher() {
        log.info("Creating publisher");
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        return Mono.fromSupplier(() -> getSum(list));
    }

    private static int getSum(List<Integer> list) {

        log.info("Executing business logic");
        Util.putThreadOnSleep(3);
        return list.stream().reduce(0, Integer::sum);
    }

}
