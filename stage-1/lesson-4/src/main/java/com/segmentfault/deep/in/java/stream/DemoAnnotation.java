package com.segmentfault.deep.in.java.stream;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DemoAnnotation {

    String value();
}
