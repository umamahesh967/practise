package com.database.jpa.hibernate.demo.generalPractise;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class MaxDifference {
    public static void main (String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        while(testCases-- > 0)
        {
            int len = Integer.parseInt(reader.readLine());
            int[] arr = new int[len];
            String[] str = reader.readLine().trim().split("\\s+");
            int sum = 0;
            for(int i=0; i<len; i++)
            {
                arr[i] = Integer.parseInt(str[i]);
                sum += arr[i];
            }

            int N = sum/2;
            boolean[][] values = new boolean[len+1][N+1];
            for(int i=0; i<=N; i++)
            {
                values[0][i] = false;
            }

            // values[0] = true;
            int max = 0;
            values[0][0] = true;
            for(int i=1; i<=len; i++)
            {
                for(int j=0; j<=N; j++)
                {
                    if(j==0)
                    {
                        values[i][j] = true;
                    }
                    else if(j >= arr[i-1])
                    {
                        values[i][j] = values[i-1][j] || values[i-1][j-arr[i-1]];
                        if(max < j && values[i][j])
                        {
                            max = j;
                        }
                    }
                    else
                    {
                        values[i][j] = values[i-1][j];
                    }
                }
            }
            System.out.println(sum - 2*max);
        }
    }
}