package com.database.jpa.hibernate.demo.generalPractise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * In Regex .(dot/period) which means "any character".
 * So to say dot we represent it as period we write it as \. and to represent in string
 * we write it as "\\." because java treats single slash as escape character so treat slash as slash
 * we write it in double slash format.
 *
 * https://stackoverflow.com/questions/3481828/how-to-split-a-string-in-java
 */
public class General
{
    static int getMedian(
            int[] a, int[] b, int startA,
            int startB, int endA, int endB)
    {
        if (endA - startA == 1) {
            return (
                    Math.max(a[startA],
                            b[startB])
                            + Math.min(a[endA], b[endB]))
                    / 2;
        }
        /* get the median of
    the first array */
        int m1 = median(a, startA, endA);

        /* get the median of
    the second array */
        int m2 = median(b, startB, endB);

        /* If medians are equal then
    return either m1 or m2 */
        if (m1 == m2) {
            return m1;
        }

        /* if m1 < m2 then median must
    exist in ar1[m1....] and
                ar2[....m2] */
        else if (m1 < m2) {
            return getMedian(
                    a, b, (endA + startA + 1) / 2,
                    startB, endA,
                    (endB + startB + 1) / 2);
        }

        /* if m1 > m2 then median must
    exist in ar1[....m1] and
    ar2[m2...] */
        else {
            return getMedian(
                    a, b, startA,
                    (endB + startB + 1) / 2,
                    (endA + startA + 1) / 2, endB);
        }
    }

    /* Function to get median
    of a sorted array */
    static int median(
            int[] arr, int start, int end)
    {
        int n = end - start + 1;
        if (n % 2 == 0) {
            return (
                    arr[start + (n / 2)]
                            + arr[start + (n / 2 - 1)])
                    / 2;
        }
        else {
            return arr[start + n / 2];
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        int ar1[] = { 1, 2, 3, 6 ,9, 10};
        int ar2[] = { 4, 6, 8, 10 , 12, 14};
        int n1 = ar1.length;
        int n2 = ar2.length;
        if (n1 != n2) {
            System.out.println(
                    "Doesn't work for arrays "
                            + "of unequal size");
        }
        else if (n1 == 0) {
            System.out.println("Arrays are empty.");
        }
        else if (n1 == 1) {
            System.out.println((ar1[0] + ar2[0]) / 2);
        }
        else {
            System.out.println(
                    "Median is "
                            + getMedian(
                            ar1, ar2, 0, 0,
                            ar1.length - 1, ar2.length - 1));
        }
    }
}
