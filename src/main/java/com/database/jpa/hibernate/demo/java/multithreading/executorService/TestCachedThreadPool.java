package com.database.jpa.hibernate.demo.java.multithreading.executorService;

import com.database.jpa.hibernate.demo.java.multithreading.callable.TestCallable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//CachedThreadPool  Executors.newCachedThreadPool(); //Uses SynchronousQueue

//If a Task is CPU intensive task, The ideal pool size is CPU is core count.

//If a task is IO Intensive task. Then pool size can be very high.
// Why we can give very high pool size then core count is, let say task is IO operation like DB interaction
// then once request is sent to DB to get response. Until the thread get the response thread will go into waiting state.
//So Instead of thread waiting if we have high pool size then other threads can perform operations on same CPU core.

// In CachedThreadPool, if Thread is alive without performing any task for 60 seconds then that thread will be killed. It is internally taken care.
public class TestCachedThreadPool
{
    public static void main(String[] args)
    {
        //We can give much higher count for IO Intensive tasks.
        ExecutorService service = Executors.newCachedThreadPool() ;

        for (int i = 0; i < 100; i++) {
            service.submit( new Task1());
            service.execute(new Task1());
            service.submit(new Task1());
        }
    }
}

class Task1 implements Runnable
{
    @Override
    public void run()
    {
        try {
            Thread.sleep(1); //If delay is more it create up to max 100 threads.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}