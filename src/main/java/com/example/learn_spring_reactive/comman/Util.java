package com.example.learn_spring_reactive.comman;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Util {

    private static final Faker faker = Faker.instance() ;

    public static <T> DefaultSubscriber<T> subscriber() {
        return new DefaultSubscriber<>("");
    }

    public static <T> DefaultSubscriber<T> subscriber(String subscriberName) {
        return new DefaultSubscriber<>(subscriberName);
    }

    public static Faker getFaker() {
        return faker;
    }

    public static void main(String[] args) {

        var mono = Mono.just(1);

        mono.subscribe(subscriber());

        mono.subscribe(subscriber("SUB1"));
        mono.subscribe(subscriber("SUB2"));
    }


    public static void putThreadOnSleep(int seconds)
    {
        try {
            Thread.sleep(Duration.ofSeconds(seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}
