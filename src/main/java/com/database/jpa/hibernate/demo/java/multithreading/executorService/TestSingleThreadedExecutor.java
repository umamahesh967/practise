package com.database.jpa.hibernate.demo.java.multithreading.executorService;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Internally Uses Blocking queue.
 *
 * After submitting all tasks, they will be stored in queue and each task will be executed in FCFS(First come first serve manner).
 * If you want threads to executed sequentially then you can use this.
 */
public class TestSingleThreadedExecutor
{
    public static void main(String[] args)
    {
        ExecutorService service = Executors.newSingleThreadExecutor();

        for(int i=0; i<5; i++)
        {
            service.submit(new Task3()); //Here threads to executed sequentially.
        }
    }
}


class Task3 implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("Started:"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ended:"+Thread.currentThread().getName());
    }
}