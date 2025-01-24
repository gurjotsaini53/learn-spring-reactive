package com.example.learn_spring_reactive.sec02;

import com.example.learn_spring_reactive.comman.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec07MonoFromCallable {

    private final static Logger log = LoggerFactory.getLogger(Lec07MonoFromCallable.class);

    /*
     *  to delay the execution using supplier / callable
     *
     * */

    /*
    *
    * 1. Mono.fromSupplier
        Description: Accepts a Supplier<T> that provides a result.
        Execution: The supplier is lazily executed, meaning it will not run until the Mono is subscribed to.
        Exception Handling: If the supplier throws a checked exception, it must be handled manually (e.g., wrapped in a RuntimeException).
    *
    *
    *
    *
    * 2. Mono.fromCallable
        Description: Accepts a Callable<T> that provides a result or throws a checked exception.
        Execution: Like fromSupplier, execution is lazy and will only occur when the Mono is subscribed to.
        Exception Handling: If the callable throws a checked exception, Mono will handle it and propagate the error as a signal (onError).

    *
    *
    *
    *
    *  Key Differences
    Feature	Mono.fromSupplier	Mono.fromCallable
    Input	Supplier<T>	Callable<T>
    Exception Handling	Does not natively handle checked exceptions	Handles checked exceptions and propagates them
    Use Case	When no checked exceptions are expected	When checked exceptions need to be handled
    Example Computation	Simple data retrieval or logic without exceptions	Computation that may throw exceptions
    When to Use
    Use fromSupplier if your logic doesn't involve checked exceptions and is straightforward (e.g., retrieving a cached value or constant).
    Use fromCallable when your logic may throw checked exceptions and you want Mono to handle them as error signals.
    In your example, Mono.fromCallable(() -> getSum(List.of(1, 2, 3, 2, 5))) is appropriate because getSum declares a checked exception. If you used fromSupplier, you'd need to handle the exception manually.
    *
    *
    * */


    public static void main(String[] args) {

        Mono.fromCallable(() -> getSum(List.of(1, 2, 3, 2, 5))).subscribe(Util.subscriber());

    }


    public static int getSum(List<Integer> list) throws Exception {
        log.info("Getting sum of list {} ", list);
        return list.stream().mapToInt(a -> a).sum();
    }
}
