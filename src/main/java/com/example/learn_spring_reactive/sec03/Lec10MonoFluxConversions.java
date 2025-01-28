package com.example.learn_spring_reactive.sec03;

import com.example.learn_spring_reactive.comman.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec10MonoFluxConversions {


    /*
    * Mono Flux conversion
    * */
    public static void main(String[] args) {

        monoToFlux();

        fluxToMono();

    }


    public static void fluxToMono() {
        var mono = Mono.just("Hello World");
        Flux.from(mono).subscribe(Util.subscriber());
    }



    public static void monoToFlux() {
        var mono = getUsername(1);
        save(Flux.from(mono));
    }


    public static  Mono<String> getUsername(int n){
        switch (n){
            case 1:
                return Mono.just("Gurjot");
            case 2:
                return Mono.empty();
            default:
                return Mono.error(new RuntimeException(" Wrong input"));
        }
    }



    public static void save(Flux<String > flux )
    {
        flux.subscribe(Util.subscriber());
    }
}
