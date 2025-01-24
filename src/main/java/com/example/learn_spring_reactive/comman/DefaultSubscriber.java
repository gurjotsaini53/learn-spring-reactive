package com.example.learn_spring_reactive.comman;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSubscriber<T> implements Subscriber<T> {

    private static Logger log= LoggerFactory.getLogger(DefaultSubscriber.class);

    private Subscription subscription;

    private String name;

    public DefaultSubscriber(String  name) {
        this.name = name;
    }

    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T item) {
        log.info("{} received : {}", this.name,item);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("{} error",this.name,throwable);
    }

    @Override
    public void onComplete() {
        log.info("{} request complete ",this.name);
    }
}
