package com.example.learn_spring_reactive.sec03;

import com.example.learn_spring_reactive.comman.Util;
import com.example.learn_spring_reactive.sec02.client.ExternalServiceClient;

public class Lec07FluxStreamming {

    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        client.getNames().subscribe(Util.subscriber());
        Util.putThreadOnSleep(5);

    }
}
