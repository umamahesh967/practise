package com.database.jpa.hibernate.demo.java.multithreading;


import java.util.concurrent.CompletableFuture;

/**
 *
 * Every thread that you create is actually a operating system thread which is also called as native thread/kernel thread.

 * Every thread in java has Program Counter, Java Stacks and Stack Frames and so on.
 *
 */
public class JavaAsynchronous
{

    public static void main(String[] args)
    {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> m1())
                .thenApplyAsync((a) -> m1())
                .thenApplyAsync((b) -> m1())
                .thenAcceptAsync((c) -> m1());
    }

    public static int m1()
    {
        System.out.println(Thread.currentThread().getName());
        return 5;
    }
}
