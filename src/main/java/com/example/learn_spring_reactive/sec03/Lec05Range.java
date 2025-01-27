package com.example.learn_spring_reactive.sec03;

import com.example.learn_spring_reactive.comman.Util;
import reactor.core.publisher.Flux;

public class Lec05Range {

    public static void main(String[] args) {


         // 1 to 10
        Flux.range(1,10).subscribe(Util.subscriber());

        // 3 to 12  - starts from 3  + 10 numbers i.e till 12
        Flux.range(3,10).subscribe(Util.subscriber());


        Flux.range(1,10)
                .map(i->Util.getFaker().name().firstName())
                .subscribe(Util.subscriber());

    }
}
