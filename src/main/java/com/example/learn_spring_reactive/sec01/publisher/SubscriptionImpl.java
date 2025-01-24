package com.example.learn_spring_reactive.sec01.publisher;

import com.example.learn_spring_reactive.sec01.subscriber.SubscriberImpl;
import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SubscriptionImpl implements Subscription {

    private final static Logger log = LoggerFactory.getLogger(SubscriptionImpl.class);

    private final Subscriber<? super String> subscriber;
    private final Faker faker;
    private final int MAX_ITEMS = 10;
    private int count = 0;
    private boolean isCancelled = false;

    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }

    @Override
    public void request(long requested) {

        log.info("Subscriber requested for {} items", requested);
        if (isCancelled) return;

        if(requested>MAX_ITEMS)
        {
            subscriber.onError(new RuntimeException("Request too large"));
            this.isCancelled = true;
            return;
        }
        for (int i = 0; i < requested && count <= MAX_ITEMS; i++) {
            count++;
            this.subscriber.onNext(faker.internet().emailAddress());
        }

        if (count == MAX_ITEMS) {
            log.info("no items to produce");
            this.subscriber.onComplete();
            this.isCancelled = true;
        }

    }

    @Override
    public void cancel() {
        log.info("Subscription cancelled");
        isCancelled = true;
    }
}
