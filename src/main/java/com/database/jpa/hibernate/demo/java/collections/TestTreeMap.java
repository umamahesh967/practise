package com.database.jpa.hibernate.demo.java.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Here TreeMap uses {@link TreeMap.Entry} which implements Map.Entry<K,V>
 * TreeMap.Entry contains left and right pointer which are similar to BinarySearchTree
 *
 * When we are trying to add element, Compare element with root and go to left or right based on that
 * till the end and add element. After adding it internally uses Red Black Algorithm to balance tree.
 *
 * So put operation takes O(logn)
 *
 * Get operation is also similar to searching for element in BinarySearchTree takes O(logn).
 *
 * for removing the element als o takes 0(logn)
 *
 * How TreeMap internally uses Red Black Algorithm
 * https://stackoverflow.com/questions/31779786/how-tree-map-uses-red-black-tree-algorithm
 */
public class TestTreeMap
{
    public static void main(String[] args)
    {
        TreeMap<Integer, Integer> map = new TreeMap();
        map.put(2,3);
        map.put(5,6);
        map.put(7,8);
        map.put(7,9);
        map.put(0,1);


        map.get(2);

        System.out.println(map);
    }
}
