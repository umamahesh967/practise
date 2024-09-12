package com.database.jpa.hibernate.demo.java.multithreading.executorService;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadingExecutorService
{
    public static void main(String[] args)
    {
        //We can give much higher count for IO Intensive tasks.
        //Internally fixedThreadPool uses Blocking queue to store all the tasks we submit.
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 50; i++) {
            service.submit( new Task());
        }
    }
}

class Task implements Runnable
{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
//If a Task is CPU intensive task, The ideal pool size is CPU is core count.

//If a task is IO Intensive task. Then pool size can be very high.
// Why we can give very high pool size then core count is, let say task is IO operation like DB interaction
// then once request is sent to DB to get response. Until the thread get the response thread will go into waiting state.
//So Instead of thread waiting if we have high pool size then other threads can perform operations on same CPU core.


//Java has four kind of ThreadPool   https://www.youtube.com/watch?v=sIkG0X4fqs4&list=PLhfHPmPYPPRk6yMrcbfafFGSbE2EPK_A6&index=6
//1. FixedThreadPool      Executors.newFixedThreadPool(5);
// **Uses BlockingQueue, Since fixed threads has to fetch the tasks from queue one after the other.


//2. CachedThreadPool     Executors.newCachedThreadPool(); //Uses SynchronousQueue
//*** When you add a task to queue, Since synchronous queue can hold only one task, after adding it search for
//  any idle threads to perform the task. If it doesn't it creates an new Thread and assigns the task.


//3. ScheduledThreadPool  Executors.newScheduledThreadPool(); //Uses DelayQueue
// *** Delay queue doesn't hold task sequential(not in the manner we added tasks), it holds in the order
// in which it should execute the tasks.

//4. SingleThreadedExecutor  //Uses BlockingQueue of size 1.

