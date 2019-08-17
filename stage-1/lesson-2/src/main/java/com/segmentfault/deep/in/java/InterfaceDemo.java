package com.segmentfault.deep.in.java;

import java.io.Serializable;

public class InterfaceDemo {

    public static void main(String[] args) {
        // 强类型约束
        println(1); // 1 -> int => Integer <- Number

        // String 既是 CharSequence，也是 Serializable
        println((CharSequence)"Hello");
    }

    private static void println(Serializable number) {
        System.out.println(number);
    }

    private static void println(CharSequence charSequence) {
        System.out.println(charSequence.length());
    }

    public interface A {
        int VALUE = 1;
    }
}
