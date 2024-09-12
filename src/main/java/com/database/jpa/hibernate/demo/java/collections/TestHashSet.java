package com.database.jpa.hibernate.demo.java.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet internally uses HashMap to store elements.
 * HashMap key will be set values and HashMap value is dummy Object.
 * Internally when we do set.add(5) it actually is map.put(5,new Object());
 * new Object() is dummy value we are storing.
 */
public class TestHashSet
{
    public static void main(String[] args)
    {
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(5);
        System.out.println(set.add(3));
        System.out.println(set.add(6));
    }
}
