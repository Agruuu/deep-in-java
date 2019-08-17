package com.segmentfault.deep.in.java.generic;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassCastDemo {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add("a");

        Type type = int.class;
        Class cls = int.class;
        System.out.println(type.getTypeName());

        List<String> strList = Collections.emptyList();
        // Arrays.asList() 是不可变类，只读 是个内部类，继承了 AbstractList 抽象类
        List<String> strList2 = Arrays.asList("1", "2", "3");
        // Diamond 写法
        List<String> strList3 = new ArrayList<>();
        // Java 10 var
        // var strList = new ArrayList<>();
    }

    /**
     * a String List
     * b Integer List
     * String -> Integer
     * for-each
     * @param a
     * @param b
     */
    private static void exchange(List a, List b) {

    }
}
