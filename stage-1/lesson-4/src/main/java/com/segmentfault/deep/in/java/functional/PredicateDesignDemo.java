package com.segmentfault.deep.in.java.functional;
import java.util.*;

import java.util.function.Predicate;

public class PredicateDesignDemo {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        Collection<Integer> even = filter(numbers, num -> num % 2 != 0);
        even.forEach(System.out::println );
    }

    private static <E> Collection<E> filter(Collection<E> source, Predicate<E> predicate) {

        List<E> copy = new ArrayList<E>(source);
        Iterator<E> iterator = copy.iterator();
        while (iterator.hasNext()) {
            E  element = iterator.next();
            if (!predicate.test(element)) {
                iterator.remove();
            }
        }

        return Collections.unmodifiableList(copy);
    }
}
