package com.segmentfault.deep.in.java.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ClassUtil {

    public static <T> Class<T> resolveGenericType(Class<?> declaredClass) {
        ParameterizedType parameterizedType = (ParameterizedType) declaredClass.getGenericSuperclass();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        return (Class<T>) actualTypeArguments[0];
    }
}
