package com.example.learn_spring_reactive.sec02;

import com.example.learn_spring_reactive.comman.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec06MonoFromSupplier {

    private final static Logger log = LoggerFactory.getLogger(Lec06MonoFromSupplier.class);

    /*
    *  to delay the execution using supplier / callable
    *
    * */


    public static void main(String[] args) {

        Mono.fromSupplier(() -> getSum(List.of(1,2,3,2,5))).subscribe(Util.subscriber());

    }

    public static int getSum(List<Integer> list)
    {
        log.info("Getting sum of list {} ",list);
        return list.stream().mapToInt(a->a).sum();
    }
}
