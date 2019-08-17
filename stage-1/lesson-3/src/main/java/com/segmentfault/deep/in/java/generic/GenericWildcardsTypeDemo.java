package com.segmentfault.deep.in.java.generic;
import javax.imageio.ImageTranscoder;
import	java.util.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 通配符
 */
public class GenericWildcardsTypeDemo {

    public static void main(String[] args) {

        // 泛型上界通配符类型（配型）
        // Number -> Byte, Short, Integer, Long
        List<Number> numbers = new ArrayList<>();

        upperBoundedWildcards(numbers);
        unboundedWildcards(numbers);

        lowerBoundedWildcards(numbers);
    }

    private static void upperBoundedWildcards(List<Number> numbers) {
        numbers.add(Byte.valueOf((byte) 1));
        numbers.add(Short.valueOf((byte) 2));
        numbers.add(Integer.valueOf(3));
        numbers.add(Long.valueOf(4L));

        List<Byte> bytes = Arrays.asList((byte) 5 );
        List<Short> shorts = Arrays.asList((short) 6);
        List<Integer> integers = Arrays.asList(7);

        numbers.addAll(bytes); // ? extends Number; List<Byte>
        numbers.addAll(shorts); // ? extends Number; List<Short>
        numbers.addAll(integers); // ? extends Number; List<Integer>

        // 被操作（处理）的对象，需要更为抽象类型，Number
        // 待整合（输入）的对象，可以是具体类型
        upperBoundedWildcardsDemo(numbers, System.out::println);
    }

    private static void unboundedWildcards(List<Number> numbers) {
        // 完全通配符配型（类型）
        // 在运行时于非通配泛型会出现方法签名冲突，因为两者是相同
        // 然后完全通配类型，可以适配任意类型，比如集合
        // 反而具体类型泛型，会限制类型的范围
        unboundedWildcardsDemo(numbers);
    }

    private static void lowerBoundedWildcards(List<Number> numbers) {
        lowerBoundedWildcardsDemo(numbers, numbers);
    }

    private static void lowerBoundedWildcardsDemo(List<? extends Number> producer, List<? super Number> consumer) {
        // 读取数据（生产者）使用 extends
        for (Object e : producer) {

        }
        // 操作输出（消费者）使用 super
        consumer.add(1);
        consumer.add((short)1);
    }

    public static void upperBoundedWildcardsDemo(Iterable<? extends Number> list, Consumer<Object> consumer) {
        for (Object e : list) {
            consumer.accept(e);
        }
    }

    public static void unboundedWildcardsDemo(Iterable<?> iterable ) { // 泛型类型擦写，导致和下方法冲突
        for (Object e : iterable) {
            System.out.println(e);
        }
    }

//    public static void println(Iterable<Object> iterable) {
//        for (Object e : iterable) {
//            System.out.println(e);
//        }
//    }
}
