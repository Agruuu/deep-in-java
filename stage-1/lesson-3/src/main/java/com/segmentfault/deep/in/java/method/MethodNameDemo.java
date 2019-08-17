package com.segmentfault.deep.in.java.method;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

/**
 * 方法名设计
 */
public class MethodNameDemo {

    public static void main(String[] args) {

        //
        Stream.of(3, 1, 2, 5).forEachOrdered(System.out::println);

        Lock lock = new ReentrantLock();
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    //
    public class ViewRander { // 名词

        // 渲染
        public void rander() { // 单一动词

        }

        // 同步渲染
        public void randerSynchronously() {     // 动词 + 副词

        }

        // 并发渲染
        public void randerConcurrently() {  // 动词 + 副词

        }
    }
}
