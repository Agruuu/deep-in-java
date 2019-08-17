package com.segmentfault.deep.in.java.generic;
import java.io.Serializable;
import	java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Consumer;

/**
 * 泛型
 */
public class GenericParameterTypeDemo {

    public static void main(String[] args) {

//        Container<E> a = new Container("String");
        Container<String> str = new Container("String");
        System.out.println(str.get());

        // Error: Integer 不是 CharSequence 子类
//        Container<Integer> str2 = new Container(1);

        // StringBuffer -> Object

        // 编译时为什么不报错？
        // StringBuffer 是 CharSequence 子类
        // String(参数) 也是 CharSequence 子类
        // 运行时：被擦掉了 都变成 Object
        Container<StringBuffer> str3 = new Container("Hello World");
        // 通过构造器传递参数是 String 类型，运行时都是 Object，没有问题
        System.out.println(str3.get()); // Hello World
        // 不过当 str3 对象声明的类型为 Container<StringBuffer>，
        // E 类型为 StringBuffer，因此 set(E)，E 必须是 StringBuffer
        str3.set(new StringBuffer("2019"));
        System.out.println(str3.get()); // 2019

        // Java 泛型对象操作时，看声明对象泛型参数类型

        add(new ArrayList<>(), "Hello World");
        add(new ArrayList<>(), 1); // auto-boxing 256 = new Integer(256) <- Integer.valueOf(256)
        add(new HashSet<>(), 1);

        forEach(Arrays.asList(1, 2, 3, "one", "two", "three"), GenericParameterTypeDemo::print);
        forEach(Arrays.asList(1, 2, 3, "one", "two", "three"), System.out::println);
    }


    private static void print(Serializable obj) {
        System.out.print(obj + ",");
    }

    // 单界限泛型参数类型
    // extends 声明它上限，E 的上限类型是 CharSequence
    public static class Container<E extends CharSequence > {

        private E element;

        public Container(E e) {
            this.element = e;
        }

        public E get() {
            return this.element;
        }

        public boolean set(E e) {
            this.element = e;
            return true;
        }
    }

    //
    public static class C {

    }

    public static interface I {}

    public static interface I2 {}

    // 多界限泛型参数类型 extends 第一个类型允许是具体累（也可以是接口）
    // 第二或更多参数类型必须是接口
    public static class Template<T extends C & I & I2> {

    }

    public static class TClass /*extends C*/ implements I, I2 {

    }


    // 范型方法和有界类型参数
    // 把一个类型的元素，添加到集合中
    public static <E extends Serializable> void adds(Collection<E> target, E element) {
        target.add(element);
    }

    public static <C extends Collection<E>, E extends Serializable> void add(C target, E element) {
        target.add(element);
    }

    public static <C extends Iterable<E>,E extends Serializable> void forEach(C source, Consumer<E> consumer) {
        for (E e : source) {
            consumer.accept(e);
        }
    }
}




















