package com.example.learn_spring_reactive.sec01;


/*
* 1. producer does not produce until the subscriber request for it.
* 2. producer will only produce items <= requested by subscriber. Producer can also produce 0 items.
* 3. subscriber can cancel the subscription and producer should stop at that moment as subscriber is not interested in consuming the data.
* 4. producer can send error signal to subscriber to indicate something is wrong.
*
* */

import com.example.learn_spring_reactive.sec01.publisher.PublisherImpl;
import com.example.learn_spring_reactive.sec01.subscriber.SubscriberImpl;

import java.time.Duration;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

//        demo1();
//        demo2();
//        demo3();
        demo4();


    }

    public static void demo1() {
        PublisherImpl publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
    }

    public static void demo2() throws InterruptedException {
        PublisherImpl publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(1);

        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(2);

        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(1);

        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(2);

        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(1);

        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);

        // above completed 1+2+1+2+1+3 = 10
        // which is max for a producer  can send ...... :)


        // no more data to send , this below statement won't work

        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(10);
    }



    public static void demo3() throws InterruptedException {
        PublisherImpl publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(1);

        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(2);

        Thread.sleep(Duration.ofSeconds(2));

        // cancel the subscription
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(1);

        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(2);

        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(1);

        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);


    }


    public static void demo4() throws InterruptedException {
        PublisherImpl publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(1);

        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(2);

        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(111);

        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(2);

        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(1);

        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);


    }
}
