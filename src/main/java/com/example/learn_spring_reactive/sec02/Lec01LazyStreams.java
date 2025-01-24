package com.example.learn_spring_reactive.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

/*
 *  if we don't use the terminal operator , then the streams will not execute , due to its default behavior
 * */
public class Lec01LazyStreams {

    private final static Logger log = LoggerFactory.getLogger(Lec01LazyStreams.class);

    public static void main(String[] args) {
        // the default behaviour of steams is lazy , so we have to use a terminal operator

        // streams will not execute
        Stream.of(2).peek(i -> log.info("received {} ", i));

        // streams will execute
        Stream.of(2).peek(i -> log.info("received {} ", i)).toList();
    }
}
