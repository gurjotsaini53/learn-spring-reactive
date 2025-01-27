package com.example.learn_spring_reactive.sec03;

import com.example.learn_spring_reactive.comman.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec04FluxStream {
    public static void main(String[] args) {


        var list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        var stream = list.stream();

        Flux.fromStream(stream).subscribe(Util.subscriber("sub1"));

        // stream once closed cant be used for other
        Flux.fromStream(stream).subscribe(Util.subscriber("sub2"));

        // use supplier methods
        Flux.fromStream(()->list.stream()).subscribe(Util.subscriber("sub3"));

        Flux.fromStream(list::stream).subscribe(Util.subscriber("sub4"));
    }
}
