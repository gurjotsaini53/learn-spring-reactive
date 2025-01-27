package com.example.learn_spring_reactive.sec03;

import com.example.learn_spring_reactive.comman.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Lec03FluxFromIterableOrArray {

    public static void main(String[] args) {

        var list = List.of(1, 2, 3, 4, 5);

        Flux.fromIterable(list).subscribe(Util.subscriber());


        Integer[] arr = {1, 2, 3, 4, 5};

        Flux.fromArray(arr).subscribe(Util.subscriber());
    }
}
