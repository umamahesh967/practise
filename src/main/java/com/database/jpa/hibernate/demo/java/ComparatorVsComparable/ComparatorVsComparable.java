package com.database.jpa.hibernate.demo.java.ComparatorVsComparable;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparable uses compareTo() method (Used for default sorting order)
 *
 * Comparator uses compare() method (Used for customized sorting order)
 *
 * a.compareTo(b) for Ascending Order
 * +1 mean swap a > b
 * -1 means a < b
 * 0 means same order
 */
public class ComparatorVsComparable
{
    public static void main(String[] args)
    {
        Integer[] arr = new Integer[5];

        Arrays.sort(arr);//Default sorting, internally uses comparable's compareTo method.

        Comparator comparator = (a, b) -> {return -1;};
        Arrays.sort(arr, comparator);//Customized sorting. Uses Comparator compare method.
    }
}
