package com.example.learn_spring_reactive.sec02;

import com.example.learn_spring_reactive.comman.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec09MonoFromFuture {


    /*
     * If you have a completable Future already , convert it to mono empty
     *
     * */

    private static final Logger log = LoggerFactory.getLogger(Lec09MonoFromFuture.class);


    public static void main(String[] args) {

        // this completeable will occupy a thread and start doing its computation
        // because here producer does not have a subscrier so that data is generated but no one is getting it
       // Mono.fromFuture(getData());


       // here 2 thread are running main thread and then getData() async thread
        // not both run separately
        // getData() will do its work
        // but not received at Main thread to supply to Subsciber
       //  Mono.fromFuture(getData()).subscribe(Util.subscriber());



        // to resolve above problem we have to block the Main thread
        // e.g. put thread on sleep

        Util.putThreadOnSleep(2);




        Mono.fromFuture(Lec09MonoFromFuture::getData).subscribe(Util.subscriber());
        Util.putThreadOnSleep(2);

    }


    private static CompletableFuture<String> getData()
    {
        return CompletableFuture.supplyAsync(()->{
            log.info("Generating Data");
            return Util.getFaker().name().firstName();
        });
    }


}
