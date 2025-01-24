package com.example.learn_spring_reactive.sec02;

import com.example.learn_spring_reactive.comman.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;


public class Lec10PublisherCreateVsExecution {


    private final static Logger log = LoggerFactory.getLogger(Lec10PublisherCreateVsExecution.class.getName());

    public static void main(String[] args) {

        // function will be called
        // because we dont any subscriber here so there wont be any data generating
        createMono();

        createMono().subscribe(Util.subscriber());

    }


    private static Mono<String> createMono(){
        log.info("Method called - create mono");
        return Mono.fromSupplier(
                ()->{
                    log.info("Started generating data");
                    Util.putThreadOnSleep(2);
                    return Util.getFaker().name().firstName();
                }
        );
    }
}
