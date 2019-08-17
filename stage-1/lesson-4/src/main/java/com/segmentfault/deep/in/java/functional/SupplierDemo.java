package com.segmentfault.deep.in.java.functional;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {

        Supplier<Long> s = getLong();
//        s.get();

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
//                return "Hello, World";
                return getHelloWorld();
            }
        };

        Callable<String> callable1 = SupplierDemo::getHelloWorld;
    }

    public static String getHelloWorld() {
        return "Hello, World";
    }

    public static Supplier<Long> getLong() {
//        return () -> {
//            return System.currentTimeMillis();
//        };
        return System::currentTimeMillis;
    }
}
