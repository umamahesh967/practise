package com.database.jpa.hibernate.demo.generalPractise;

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args)
    {
        // ArrayList<String> strings = new ArrayList<String>();
        // strings.add("Hello, World!");
        // strings.add("Please put code below");
        // for (String string : strings) {
        //   System.out.println(string);
        // }

        int[] val = {40, 100, 50, 60};
        int[] wt = {20, 10, 40, 30};
        int W = 60;

        int len = val.length;
        int[][] arr = new int[len+1][W+1];
        int[] elements = new int[W+1];

        for(int i=0; i<=len; i++)
        {
            for(int j=0; j<=W; j++)
            {
                if(i==0 || j==0)
                {
                    arr[i][j] = 0;
                }
                else
                {
                    if(wt[i-1] <= j)
                    {
                        int max = Math.max(arr[i-1][j], val[i-1] + arr[i-1][j - wt[i-1]]);
                        if(max > arr[i-1][j])
                        {
                            elements[j] = j - wt[i-1];
                        }
                        arr[i][j] = max;
                    }
                    else
                    {
                        arr[i][j] = arr[i-1][j];
                    }
                }
            }
        }

        int i=len,j=W;
        while(j > 0)
        {
            if(arr[i][j] != arr[i-1][j])
            {
                System.out.println(wt[i-1]);
                j = j - wt[i-1];
                i = i-1;
            }
            else
            {
                i = i-1;
            }
        }

        System.out.println(arr[len][W]);
    }
}
