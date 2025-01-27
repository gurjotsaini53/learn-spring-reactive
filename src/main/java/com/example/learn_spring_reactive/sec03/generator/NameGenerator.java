package com.example.learn_spring_reactive.sec03.generator;

import com.example.learn_spring_reactive.comman.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.IntStream;

public class NameGenerator {



    public static List<String> getNameList(int count)
    {
        return IntStream.rangeClosed(1,count).mapToObj(i->generateName()).toList();
    }

    public static Flux<String> getNameFlux(int count)
    {
        return Flux.range(1,count).map(i->generateName());
    }


   public static String generateName() {
        Util.putThreadOnSleep(1);
       return Util.getFaker().name().firstName();
   }
}
