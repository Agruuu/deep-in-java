package com.segmentfault.deep.in.java.collection;

import java.util.HashSet;
import java.util.Set;

public class ListAndSetDemo {

    public static void main(String[] args) {

        // HashSet 并不能保证顺序
        Set<String> values = new HashSet<>();
        // 有些场景可能让你误导
        // 字母场景
        values.add("a");
        values.add("b");
        values.add("c");
        values.forEach(System.out::println);

        values.clear();

        // 数字场景
        values.add("1");
        values.add("2");
        values.add("3");
        values.forEach(System.out::println);


    }
}
