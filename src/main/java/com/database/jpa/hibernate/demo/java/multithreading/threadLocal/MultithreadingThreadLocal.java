package com.database.jpa.hibernate.demo.java.multithreading.threadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 The ThreadLocal class in Java allows programmers to create variables that are accessible only to the thread that created them.
 This is useful for creating thread-safe code,
 as it ensures that each thread has its own copy of a variable and can not interfere with other threads.
 */
public class MultithreadingThreadLocal
{
    public static int count = 0;
    public static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial( () -> ++count);

    public static void main(String[] args)
    {
        ExecutorService service = Executors.newFixedThreadPool(5);

        MultithreadingThreadLocal multithreadingThreadLocal = new MultithreadingThreadLocal();
        for (int i = 0; i < 50; i++) {
            service.submit( () -> {new MultithreadingThreadLocal().test();});
        }
    }

    public void test()
    {
        System.out.println(threadLocal.get() + " "+ threadLocal.get());
    }
}
