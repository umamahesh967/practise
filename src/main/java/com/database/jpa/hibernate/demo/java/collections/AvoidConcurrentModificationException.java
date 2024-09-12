package com.database.jpa.hibernate.demo.java.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * Way to avoid concurrent modification exception using Normal Collection.
 *
 * We get concurrent modification exception because here Iterator doesn't have any lock to prevent
 * other threads from adding, so to avoid this if we hold lock of map object while iterating or adding
 * we will not get concurrent modification exception(CME).
 *
 * We get concurrent modification for both Thread Safe Collection and for non thread safe collection.
 * Thread Safe Collection(Vector, HashTable)
 * Non thread safe collection(HashMap, ArrayList,...etc)
 *
 * In Non thread safe collection we have to hold lock at both the place i.e while iterating and
 * while adding elements.
 * Look below link to understand how we achieve thread safe on non thread safe collection.
 * https://www.codejava.net/java-core/collections/understanding-collections-and-thread-safety-in-java
 *
 *
 * In Thread Safe Collection we have to hold lock only while iterating because put method is synchronized
 *
 * So to avoid CME and for better performance we should use Concurrent Collection which avoid CME in different ways.
 *
 * All collection class iterators are Fail-fast iterators.
 * All concurrent collection class iterators are Fail-safe iterators. that's why we don't get CME.
 *
 */
public class AvoidConcurrentModificationException
{
    public static void main(String[] args) throws InterruptedException {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,3);

        new Thread(() -> {
            try {
                System.out.println("starting");
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
//                map.put(3,4);
                while (iterator.hasNext()) {
                    System.out.println("removed");
                    iterator.next();
//                    iterator.remove();
                    Thread.sleep(2000);
                }
                synchronized (map)
                {
                    map.put(3,4);
                }
                System.out.println("Added element 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        synchronized (map)
        {
            while (iterator.hasNext()) {
                System.out.println(iterator.next().getKey());
                System.out.println("Map Size"+ map.size());
                Thread.sleep(2000);
            }
        }
        System.out.println("Done"+ map.size());
    }
}
