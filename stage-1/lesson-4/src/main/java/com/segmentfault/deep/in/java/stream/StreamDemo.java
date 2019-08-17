package com.segmentfault.deep.in.java.stream;

import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        count(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    private static void count(Integer... numbers) {
        Stream.of(numbers)
                .reduce(Integer::sum)   // 合并
                .ifPresent(System.out::println);
    }
}
