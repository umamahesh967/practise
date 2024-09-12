package com.database.jpa.hibernate.demo.java.multithreading.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//https://www.youtube.com/watch?v=NEZ2ASoP_nY&list=PLhfHPmPYPPRk6yMrcbfafFGSbE2EPK_A6&index=8
public class TestCallable
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        ExecutorService service = Executors.newFixedThreadPool(5);

        Future<Integer> future = service.submit( new Task1());
        System.out.println(future.get()); //Main thread will be blocked here, until we get the response from thread.

        /**
         * Cancel the task.
         * If the task is not started yet, then it will cancel the task.
         * If the task is started, then boolean flag(true) will interrupt the running thread.
         * If the task is started, then boolean flag(false) will not interrupt the running thread.
         */
        future.cancel(true);

        future.isCancelled();// Returns true if the task is cancelled.

        future.isDone(); //Returns true if the task is completed (successfully or otherwise).

        List<Future> futures = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Future<Integer> future1 = service.submit( new Task1());
//            System.out.println(future.get()); //Main thread will be blocked here, until we get the response from thread. So it not recommended to call get method
            futures.add(future1);
        }

        for(Future future1: futures)
        {
            System.out.println(future1.get());
        }
    }
}

class Task1 implements Callable<Integer>
{
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }
}
