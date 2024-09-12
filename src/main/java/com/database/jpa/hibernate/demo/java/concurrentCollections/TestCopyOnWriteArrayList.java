package com.database.jpa.hibernate.demo.java.concurrentCollections;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * While iterating the CopyOnWriteArrayList if another thread make changes those changes will not reflected.
 * Because when we add or set element new copy will be created and updated in that copy.
 * After updating, that copy this will be made as original array.
 * Since initial iterator was created on initial original array. updated elements will not be present that array.
 */
public class TestCopyOnWriteArrayList
{
    public static void main(String[] args) throws InterruptedException
    {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);

//        new Thread(() -> {
//            try {
//                Thread.sleep(1);
//
//                list.add(3);
//                list.add(4);
//                list.add(5);
//                list.add(6);
//                list.add(7);
//                System.out.println(list);
//                Thread.sleep(0);
//                list.add(8);
//                list.add(9);
//                list.add(10);
//                list.add(11);
//                System.out.println("Added element 3");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

//        System.out.println(list);
        Iterator<Integer> iterator = list.iterator();
        System.out.println(list);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            list.add(3);
        }
        System.out.println(list);
    }
}
