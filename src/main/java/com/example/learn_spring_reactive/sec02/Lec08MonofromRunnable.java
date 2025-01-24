package com.example.learn_spring_reactive.sec02;

import com.example.learn_spring_reactive.comman.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec08MonofromRunnable {


    /*
     * Emitting empty after some method invocation
     * */

    private static final Logger log = LoggerFactory.getLogger(Lec08MonofromRunnable.class);

    public static void main(String[] args) {

        getProduct(1).subscribe(Util.subscriber());

    }


    private static Mono getProduct(int id) {
        switch (id) {
            case 1:
             return Mono.just(Util.getFaker().commerce().productName());
            case 2:
              return   Mono.fromRunnable(() -> notifyBusinessAboutProductNotAvailable());
            default:
                return Mono.empty();
        }
    }

    private static void notifyBusinessAboutProductNotAvailable() {

        log.info("Notify Business About Product Not Available");
    }

}
