package com.segmentfault.deep.in.java.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectDemo {

    public static void main(String[] args) {

        List<Integer> collect = Stream.of(1, 2, 3, 4, 5, 6)
                .collect(Collectors.toList());
        System.out.println(collect.getClass());
    }
}
