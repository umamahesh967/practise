package com.database.jpa.hibernate.demo.generalPractise;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test5
{
    public static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        MyThread1 thread1 = new MyThread1("1");
//        thread1.join();
        thread1.start();
//        thread1.join();
//        thread1.stop();
//        thread1.suspend();
//        thread1.resume();
        ThreadGroup threadGroup = thread1.getThreadGroup();
        ThreadGroup threadGroup1 = new ThreadGroup("tg1");
        threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup1.getName());


//        Callable
//        threadGroup.enumerate();

        lock.lock();
//        synchronized (thread1)
//        {
//
//        }
//
//        MyThread1 thread2 = new MyThread1("2");
//        thread2.start();
//        Thread.sleep(1);
        Thread.currentThread().setPriority(1);
        Thread.yield();

//        Thread.currentThread().setPriority(1);
//        Thread.yield();
//        thread2.join();
        for(int i=0; i<10; i++)
        {
            System.out.println("Main Thread");
        }
        lock.unlock();
    }
}

class MyThread1 extends Thread
{
    public String name;
    public MyThread1(String name)
    {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Test5.lock.lock();

        for(int i=0; i<10; i++)
        {
            System.out.println("Thread"+name);
        }
        Test5.lock.unlock();
    }
}