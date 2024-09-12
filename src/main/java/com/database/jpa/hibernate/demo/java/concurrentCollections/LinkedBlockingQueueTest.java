package com.database.jpa.hibernate.demo.java.concurrentCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * https://www.youtube.com/watch?v=QCMt324j64U
 *
 * https://stackoverflow.com/questions/18375334/what-is-the-difference-between-arrayblockingqueue-and-linkedblockingqueue#:~:text=ArrayBlockingQueue%20is%20always%20bounded.,This%20is%20by%20default%20Integer.&text=ArrayBlockingQueue%20is%20also%20fixed%20size,on%20top%20of%20Linked%20nodes.
 */
public class LinkedBlockingQueueTest
{
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);

        new Task8(queue).start();
        queue.put(2);
        queue.put(3);

        System.out.println(queue);
        System.out.println("main:"+queue.take());
        System.out.println("main:"+queue.take());

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
            Thread.sleep(10000);
            System.out.println("Task8:"+queue.take());
            Thread.sleep(10000);
            System.out.println("Adding element 5");
            queue.put(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
