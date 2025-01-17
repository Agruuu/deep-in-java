package com.segmentfault.deep.in.java;
import	java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumClassDemo {

    public static void main(String[] args) {

        // Q1: ONE 到底是第几个定义的
        // Q2: 能否输出所有的成员
//        println(Counting.ONE);
//        println(Counting.FIVE);

        // Q3: 为什么枚举会输出成员名称
//        println(CountingEnum.ONE);
//        println(CountingEnum.FIVE);
//
//        printCountingEnumMembers();
//
//        printEnumMeta(CountingEnum.ONE);
//        printEnumMeta(CountingEnum.FIVE);

        // 自定义实现
        printCountingMembers();
        // Java 枚举字节码提升实现 values()方法
        printCountingEnumMembers();
    }

    public static void println(Counting counting) {
        System.out.println(counting);
    }

    public static void println(CountingEnum countingEnum) {
        System.out.println(countingEnum);
    }

    public static void printCountingMembers() {
        Stream.of(Counting.values()).forEach(System.out::println);
    }

    public static void printCountingEnumMembers() {
        Stream.of(CountingEnum.values())
                .forEach(System.out :: println);
    }

    public static void printEnumMeta(Enum enumeration) {
        // 说明任何枚举都扩展了 java.lang.Enum
        System.out.println("Enumeration type: " + enumeration.getClass());
        // Enum#name() == 成员名称
        // Enum#ordinal() == 成员定义位置
        System.out.println("Member: " + enumeration.name());
        System.out.println("Ordinal: " + enumeration.ordinal());
        // values() 方法是 Java 编译器给枚举提升的方法
    }
}

enum CountingEnum implements Cloneable {
    ONE(1) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    },
    TWO(2) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    },
    THREE(3) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    },
    FOUR(4) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    },
    FIVE(5) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    };

    private int value;

    /*private*/ CountingEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CountingEnum{" +
                "value=" + value +
                '}';
    }

    public abstract String valueAsString();

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    //    public static CountingEnum[] values() {
//        return Stream.of(CountingEnum.class.getDeclaredField()).filter(field -> {
//            int modifiers = field.getModifiers();
//            return Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
//        }).map(field -> {
//            try {
//                return (CountingEnum) field.get(null);
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException(e);
//            }
//        }).collect(Collectors.toSet()).toArray(new CountingEnum[0]);
//    }
}

//class ExtendedCountingEnum extends CountingEnum {
//
//}

class ExtendedCounting extends Counting {

    private ExtendedCounting(int value) {
        super(value);
    }

    @Override
    public String valueAsString() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(int value) {
        super.setValue(value);
    }
}

/**
 * 枚举类：计数
 * 强类型约束（相对于常量）
 */
abstract class Counting extends Data implements Cloneable {
    public static final Counting ONE = new Counting(1) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    };
    public static final Counting TWO = new Counting(2) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    };
    public static final Counting THREE = new Counting(3) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    };
    public static final Counting FOUR = new Counting(4) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    };
    public static final Counting FIVE = new Counting(5) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    };

    private int value;

    protected Counting(int value) {
        this.value = value;
    }

    public abstract String valueAsString();

    @Override
    public String toString() {
        return "Counting: " + value;
    }

    public static Counting[] values() {
//        Counting[] values = null;
//        Field[] fields = Counting.class.getDeclaredFields();

        // Fields -> filter -> public static final fields -> get

        return Stream.of(/*fields*/Counting.class.getDeclaredFields()).filter(field -> {
            int modifiers = field.getModifiers();
//            return (modifiers & Modifier.PUBLIC) != 0 && (modifiers & Modifier.STATIC) != 0;
            return Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        }).map(field -> {
            // Field -> Counting
            try {
                return (Counting)field.get(null);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toSet()).toArray(new Counting[0]);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }
}


//final class Counting extends Data {
//    public static final Counting ONE = new Counting(1);
//    public static final Counting TWO = new Counting(2);
//    public static final Counting THREE = new Counting(3);
//    public static final Counting FOUR = new Counting(4);
//    public static final Counting FIVE = new Counting(5);
//
//    private int value;
//
//    private Counting(int value) {
//        this.value = value;
//    }
//
//    @Override
//    public String toString() {
//        return "Counting: " + value;
//    }
//
//    public static Counting[] values() {
////        Counting[] values = null;
////        Field[] fields = Counting.class.getDeclaredFields();
//
//        // Fields -> filter -> public static final fields -> get
//
//        return Stream.of(/*fields*/Counting.class.getDeclaredFields()).filter(field -> {
//            int modifiers = field.getModifiers();
////            return (modifiers & Modifier.PUBLIC) != 0 && (modifiers & Modifier.STATIC) != 0;
//            return Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
//        }).map(field -> {
//            // Field -> Counting
//            try {
//                return (Counting)field.get(null);
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException(e);
//            }
//        }).collect(Collectors.toSet()).toArray(new Counting[0]);
//    }
//
//    @Override
//    public int getValue() {
//        return value;
//    }
//
//    @Override
//    public void setValue(int value) {
//        this.value = value;
//    }
//}
