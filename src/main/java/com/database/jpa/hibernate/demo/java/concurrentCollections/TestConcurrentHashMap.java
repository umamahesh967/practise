package com.database.jpa.hibernate.demo.java.concurrentCollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * While iterating the ConcurrentHashMap if we add elements those elements may show up or may not
 * in the iterator. It depends on what state iterator is currently present.
 */
public class TestConcurrentHashMap
{
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(9,2);
        map.put(12,3);

        new Thread(() -> {
            try {
                Thread.sleep(1);

                map.put(13,4);
                map.put(10,4);
                map.put(2,4);
                map.put(11,4);
                map.put(14,4);
                Thread.sleep(1);
                map.put(6,4);
                map.put(7,4);
                map.put(8,4);
                map.put(1,4);
                System.out.println("Added element 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();


        while (iterator.hasNext()) {
            System.out.println(iterator.next().getKey());
                Thread.sleep(1);
        }
    }
}
