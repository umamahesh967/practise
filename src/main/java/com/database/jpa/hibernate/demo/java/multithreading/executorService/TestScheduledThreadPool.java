package com.database.jpa.hibernate.demo.java.multithreading.executorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Uses DelayQueue to store the tasks and execute them.
 *
 * DelayQueue keeps the tasks in sorted manner, meaning based on the tasks it needs to be executed.
 */
public class TestScheduledThreadPool
{
    public static void main(String[] args)
    {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        service.schedule(new Task2(), 1, TimeUnit.SECONDS);

        //If time taken by runnable task is more than period between start of two tasks then next task
        // will be executed after completion of first task.
        //Task to be run repeatedly after every 1 second.
        service.scheduleAtFixedRate(new Task2(), 0, 1, TimeUnit.SECONDS);

        //Task to be run repeatedly 2 second after previous task completes regardless of how much time previous task takes.
        service.scheduleWithFixedDelay(new Task2(), 1, 2, TimeUnit.SECONDS);

    }
}


class Task2 implements Runnable
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