package com.segmentfault.deep.in.java.functional;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {

        Function<String, Long> stringToLong = Long::valueOf;

        System.out.println(stringToLong.apply("1"));

        Function<Long, String> longToString = String::valueOf;

        System.out.println(longToString.apply(3L));

        Long three = stringToLong.compose(String::valueOf).apply(12L);
        System.out.println(three);
    }
}
