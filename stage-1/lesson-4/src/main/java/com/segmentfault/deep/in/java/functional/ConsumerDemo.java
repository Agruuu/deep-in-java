package com.segmentfault.deep.in.java.functional;

import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {

        Consumer consumer1 = System.out::println;

        consumer1.accept("consumer1");

        Consumer<String> consumer2 = ConsumerDemo::echo;

//        consumer2.accept("consumer2");

        // Fluent API
        // consumer2 -> consumer1 -> consumer2
        consumer2.andThen(consumer1).andThen(consumer2).accept("consumer2");

//        consumer2.accept("consumer2 second");

//        consumer2.andThen(consumer2).accept("");
    }

    private static void echo(String message) {
        System.out.println("echo: " + message);
    }
}
