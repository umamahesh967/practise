package com.database.jpa.hibernate.demo.generalPractise;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Permutations
{
    static Set<String> set = new TreeSet<>();
    public static void main(String[] args)
    {
        permutate("abc".toCharArray(), 0,2);
        System.out.println(set);
    }

    public static void permutate(char[] arr, int start, int end)
    {
//        int i = start;
        if(start == end)
        {
//            for(char ch : arr)
//            {
//                System.out.print(ch);
//            }
            set.add(String.valueOf(arr));
            System.out.println();
            return;
        }
        for(int j = start; j<=end; j++)
        {
            swap(arr, j, start);
            permutate(arr, start+1, end);
            swap(arr, j, start);

        }
    }
    private static void swap(char[] arr, int start, int end)
    {
        char ch = arr[end];
        arr[end] = arr[start];
        arr[start] = ch;
    }
}
