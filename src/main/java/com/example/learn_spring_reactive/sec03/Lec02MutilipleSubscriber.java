package com.example.learn_spring_reactive.sec03;

import com.example.learn_spring_reactive.comman.Util;
import reactor.core.publisher.Flux;

public class Lec02MutilipleSubscriber {

    public static void main(String[] args) {


        var flux = Flux.just(1,2,3);

        flux.subscribe(Util.subscriber("Ansh"));
        flux.subscribe(Util.subscriber("Gurjot"));


        flux.filter(i -> i % 2 == 0)
                .subscribe(Util.subscriber("Gurjot"));

    }
}
