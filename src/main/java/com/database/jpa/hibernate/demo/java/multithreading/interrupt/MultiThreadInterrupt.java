package com.database.jpa.hibernate.demo.java.multithreading.interrupt;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// https://www.youtube.com/watch?v=-7ZB-jpaPPo&list=PLhfHPmPYPPRk6yMrcbfafFGSbE2EPK_A6&index=15
// Also look into the notes.
public class MultiThreadInterrupt
{
    public static void main(String[] args) throws InterruptedException
    {
        //Creating new thread using Runnable
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        thread.interrupt();

        System.out.println("Test");

        //Creating new thread using Callable
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future future = service.submit(new MyCallable());
        Thread.sleep(1000);
        future.cancel(true);
    }
}

class MyRunnable implements Runnable
{
    /**
     * If we call interrupt method and if thread is not in sleeping or waiting state then we
     * won't get any Interrupted exception. But it will wait until the thread goes into sleeping or waiting state
     * then it raises the InterruptedException. So we say that interrupt() call is never waited.
     *
     *
     * If this thread is running and when main thread calls interrupt() then we won't get
     * any InterruptedException.  Unless we handle explicitly and throw exception run method.
     *
     * But we can't throw any InterruptedException in run method because
     * If SuperClass does not declare an exception, then the SubClass can only
     * declare unchecked exceptions, but not the checked exceptions.
     * If SuperClass declares an exception, then the SubClass can only declare
     * the child exceptions of the exception declared by the SuperClass, but not any other exception.
     *
     * To handle above scenario we can use Callable, because we can throw InterruptedException in call method.
     */
    @Override
    public void run() {
        System.out.println("Runnable Not Interrupted");

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            System.out.println("Runnable Got Interrupted");
//        }

        //We can find whether thread got interrupted or not.
        System.out.println(Thread.currentThread().isInterrupted());

        //Below throw of InterruptedException is not applicable for run method. We can
//        if(Thread.currentThread().isInterrupted())
//        {
//            //If thread got interrupted then throw InterruptedException
//            throw new InterruptedException();
//        }

        //Below throw of InterruptedException is not applicable for run method. We can only
        // find if thread is interrupted and return from this method.
        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            if(Thread.currentThread().isInterrupted())
            {
                Thread.interrupted();
                System.out.println("Runnable Got Interrupted");
                return;
            }
        }

    }
}

class MyCallable implements Callable<Integer>
{
    @Override
    public Integer call() throws InterruptedException {
        System.out.println("Callable Not Interrupted");
        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            if(Thread.currentThread().isInterrupted())
            {
                //If thread got interrupted then throw InterruptedException
                System.out.println("Callable Got Interrupted");
                throw new InterruptedException();
            }
        }

        return null;
    }
}
