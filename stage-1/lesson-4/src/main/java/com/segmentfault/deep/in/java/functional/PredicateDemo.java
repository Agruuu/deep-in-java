package com.segmentfault.deep.in.java.functional;

import java.io.File;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {

        Predicate<File> filePredicate = file -> true;
    }
}
