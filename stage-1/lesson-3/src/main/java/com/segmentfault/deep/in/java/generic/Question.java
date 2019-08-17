package com.segmentfault.deep.in.java.generic;
import org.springframework.core.ResolvableType;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import	java.util.Collections;

import java.util.List;
import java.util.Map;

public class Question<T extends Serializable> {

    private List<Map<String, List<Object>>> value = Collections.emptyList();

    public static void main(String[] args) throws Exception {

        question1();
    }

    private static void question1() throws Exception {

        // 获取成员泛型参数类型
        Field field = Question.class.getDeclaredField("value");
        ResolvableType resolvableType = ResolvableType.forField(field);
        System.out.println(resolvableType.getGeneric(0));
//        System.out.println(resolvableType.asMap());

        // 获取类泛型参数类型
        TypeVariable[] parameters = Question.class.getTypeParameters();

        for (TypeVariable typeVariable : parameters) {
            System.out.println(typeVariable);
        }

        // 具体参数类型
        Question<String> question = new Question<String>();
        parameters = question.getClass().getTypeParameters();

        for (TypeVariable typeVariable : parameters) {
            System.out.println(typeVariable);
        }

        Class<?> cls = ClassUtil.resolveGenericType(Question.class);
        parameters = cls.getClass().getTypeParameters();

        for (TypeVariable typeVariable : parameters) {
            System.out.println(typeVariable);
        }
    }
}

