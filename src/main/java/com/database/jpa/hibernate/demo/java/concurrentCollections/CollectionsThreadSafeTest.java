package com.database.jpa.hibernate.demo.java.concurrentCollections;

import java.util.*;

/**
 * This test program compares performance of Vector versus ArrayList
 *
 * @author www.codejava.net
 */
public class CollectionsThreadSafeTest {

    public void testVector() {
        long startTime = System.currentTimeMillis();

        Vector<Integer> vector = new Vector<>();

        for (int i = 0; i < 100000; i++) {
            vector.addElement(i);
        }

        long endTime = System.currentTimeMillis();

        long totalTime = endTime - startTime;

        System.out.println("Test Vector: " + totalTime + " ms");

    }

    public void testArrayList() {
        long startTime = System.currentTimeMillis();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }

        long endTime = System.currentTimeMillis();

        long totalTime = endTime - startTime;

        System.out.println("Test ArrayList: " + totalTime + " ms");

    }



    public static void main(String[] args) {
        CollectionsThreadSafeTest tester = new CollectionsThreadSafeTest();

        tester.testVector();

        tester.testArrayList();

    }

}