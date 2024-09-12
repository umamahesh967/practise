package com.database.jpa.hibernate.demo.java.concurrentCollections;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TestConcurrentLinkedQueue
{
    public static void main(String[] args) throws InterruptedException
    {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.add(1);
        queue.add(2);


//        new Thread(() -> {
//            try {
////                Thread.sleep(1);
//
//                queue.add(3);
//                queue.add(4);
//                queue.add(5);
//                queue.add(6);
//                queue.add(7);
//                System.out.println(queue);
//                Thread.sleep(0);
//                queue.add(8);
//                queue.add(9);
//                queue.add(10);
//                queue.add(11);
//                System.out.println("Added element 3");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

        Iterator<Integer> iterator = queue.iterator();
        System.out.println(queue);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
//            queue.add(3);
        }

    }
}
