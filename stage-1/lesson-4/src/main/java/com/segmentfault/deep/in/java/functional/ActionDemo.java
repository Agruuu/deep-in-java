package com.segmentfault.deep.in.java.functional;

public class ActionDemo {

    public static void main(String[] args) {

        // 匿名内置类 invokespecial
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };

        // invokedynamic 指令 @since jdk 1.7
        // java.lang.invoke.MethodHandle
        // java.lang.invoke.MethodDynamic
        Runnable r2 = () -> System.out.println();
    }
}
