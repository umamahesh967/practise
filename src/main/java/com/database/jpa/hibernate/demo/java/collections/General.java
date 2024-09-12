package com.database.jpa.hibernate.demo.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Java 8 has Math.multiplyExact, Math.addExact etc. for int and long.
 * These throw an unchecked ArithmeticException on overflow.
 */
public class General
{
    public static void main(String[] args)
    {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(5,2);
        map.put(6,3);
        map.put(4,5);
        map.put(9,1);
        map.put(7,4);
        map.put(1,4);
//
//
//        map = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//                        (integer, integer2) -> integer, LinkedHashMap::new));
//        System.out.println(map);

        map = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey,
                Map.Entry::getValue,(integer, integer2) -> integer, LinkedHashMap::new ));

        long val1 = 1;
        long val2 = Long.MAX_VALUE;
        System.out.println("Value1: "+val1);
        System.out.println("Value2: "+val2);
        long sum = val1 + val2;
        if (sum > Long.MAX_VALUE) {
            throw new ArithmeticException("Overflow!");
        }
        System.out.println(Math.multiplyExact(val1, val2));
        // displaying addition
        System.out.println("Addition Result: "+sum);
    }
}
