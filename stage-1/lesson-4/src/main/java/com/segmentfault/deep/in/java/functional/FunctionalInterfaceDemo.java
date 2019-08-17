package com.segmentfault.deep.in.java.functional;

public class FunctionalInterfaceDemo {

    /**
     * 函数时接口类型
     * 提供类型 - Supplier<T>
     * 消费类型 - Consumer<T>
     * 转换类型 - Function<T, R>
     * 断定类型 - Predicate<T>
     * 隐藏类型 - Action
     */

    public static void main(String[] args) {
        Functional1 functional1 = () -> {

        };

        FunctionalWithoutAnnotation f2 = () -> {

        };
    }

    @FunctionalInterface
    public interface Functional1 {

        /*public abstract */void execute();

        // 不能出现两次方法定义
//        void execute();

        default String getDescription() {
            return String.valueOf(this);
        }
    }

//    @FunctionalInterface  // @FunctionalInterface 并非必选的
    public interface FunctionalWithoutAnnotation {

        void execute();
    }

//    @FunctionalInterface    // @FunctionalInterface 只能描述接口
//    public class FunctionClass {
//
//    }
}
