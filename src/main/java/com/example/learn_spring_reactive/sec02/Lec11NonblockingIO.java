package com.example.learn_spring_reactive.sec02;

import com.example.learn_spring_reactive.comman.Util;
import com.example.learn_spring_reactive.sec02.client.ExternalServiceClient;

import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;

public class Lec11NonblockingIO {

    /*
    *  to demo the non  blocking io
    *  ensure that external service is running and up
    *
    * */
    private final static Logger log = Logger.getLogger(Lec11NonblockingIO.class.getName());

    public static void main(String[] args) {


        log.info("starting");
        var client =  new ExternalServiceClient();

        for (int i = 0 ; i<=5 ; i++)
        {
            client.getProductName(i).subscribe(Util.subscriber());

        }

        Util.putThreadOnSleep(2);

    }
}
