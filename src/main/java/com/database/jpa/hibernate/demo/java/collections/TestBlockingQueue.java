package com.database.jpa.hibernate.demo.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestBlockingQueue
{
    public static void main(String[] args) throws InterruptedException
    {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

        new Task8(queue).start();
        queue.put(4);
        queue.put(3);
        queue.put(2);
        queue.put(1);

        System.out.println(queue);
        System.out.println(queue.take());
        System.out.println(queue.take());

//        Thread.sleep(12000);
        System.out.println(queue.take());
    }
}

class Task8 extends Thread
{
    BlockingQueue<Integer> queue;

    public Task8(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println(queue.take());
//            Thread.sleep(10000);
            System.out.println("Adding element 5");
            queue.put(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
