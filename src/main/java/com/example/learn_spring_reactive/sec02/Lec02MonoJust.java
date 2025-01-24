package com.example.learn_spring_reactive.sec02;

import com.example.learn_spring_reactive.sec01.subscriber.SubscriberImpl;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec02MonoJust {

    public static void main(String[] args) {

        // IF YOU HAVE DATE ALREADY IN THE MEMORY AND YOU WANT TO CREATE PUBLISHER OR MONO USE MONO JUST

        {
            var mono = Mono.just("Hello World");
            var subscriber = new SubscriberImpl();
            mono.subscribe(subscriber);

            subscriber.getSubscription().request(10);

            // adding these will no effect , as producer sent is complete

            subscriber.getSubscription().request(10);
            subscriber.getSubscription().cancel();
        }


        {
            var mono1 = Mono.just(List.of(1,2,3,4,5));
            var subscriber1 = new SubscriberImpl2();
            mono1.subscribe(subscriber1);
            subscriber1.getSubscription().request(1);

        }


    }
}
