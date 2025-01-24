package com.example.learn_spring_reactive.sec02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SubscriberImpl2 implements Subscriber<List<Integer>> {

    private static final Logger log = LoggerFactory.getLogger(SubscriberImpl2.class);

    private Subscription subscription;

    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void onNext(List<Integer> integers) {
        log.info("received email: {}", integers);

    }


    @Override
    public void onError(Throwable throwable) {
        log.error("error", throwable);
    }

    @Override
    public void onComplete() {
        log.info("completed");
    }
}
