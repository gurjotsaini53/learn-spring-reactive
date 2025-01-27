package com.example.learn_spring_reactive.sec03;

import com.example.learn_spring_reactive.comman.Util;
import com.example.learn_spring_reactive.sec03.generator.NameGenerator;

import java.util.List;

public class Lec06ListVsFlux {
    public static void main(String[] args) {

        // we have put thread sleep for 1 sec every name generation
        // count == time taken to get data
        // we have to wait count seconds to get data
//      List<String> list = NameGenerator.getNameList(10);
//      System.out.println(list);

         // Here we dont have to wait till we get all data
        // we are getting data as we are getting

      var flux =  NameGenerator.getNameFlux(10);
      flux.subscribe(Util.subscriber());


    }
}
