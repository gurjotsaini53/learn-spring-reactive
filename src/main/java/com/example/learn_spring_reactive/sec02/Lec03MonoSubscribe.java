package com.example.learn_spring_reactive.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    private static final Logger log = LoggerFactory.getLogger(Lec03MonoSubscribe.class);

    public static void main(String[] args) {


        // in this we are going to study various overloaded methods for mono.subscriber()

        var mono = Mono.just(1);


        /// onSubscriber it just call subscribe.getSubscription().request(Long.MAX_VALUE);

        // onSubcribe
        mono.subscribe(i -> log.info("recieved {}", i));


        // onSubscribe  + err
        mono.subscribe(i -> log.info("recieved {}", i)
        ,err -> log.error("error {} ",err));


        // onSubscribe + err + onComplete
        mono.subscribe(
                i -> log.info("recieved {}", i),
                err -> log.error("error {} ",err),
                () -> log.info("done")
        );

        // onSubscriber + err + onComplete + with custom request
        mono.subscribe(
                i -> log.info("recieved {}", i),
                err -> log.error("error {} ",err),
                () -> log.info("done with custom request"),
                subscription -> subscription.request(100)
        );

    }
}
