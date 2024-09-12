package com.database.jpa.hibernate.demo.generalPractise;


import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

class Maximize {
    public static void main (String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        while(testCases-- > 0)
        {
            int len = Integer.parseInt(reader.readLine());
            List<Integer> cut = Arrays.stream(reader.readLine()
                    .trim().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect( Collectors.toList() );

            int[] values = new int[len+1];
            for(int i=0; i<len; i++)
            {
                values[i] = Integer.MIN_VALUE;
            }

            values[0] = 0;
            for(int i=0; i<=len; i++)
            {
                for(int j=0; j<cut.size(); j++)
                {
                    if(cut.get(j) <= i && values[i-cut.get(j)] != Integer.MIN_VALUE &&values[i] < (values[i-cut.get(j)] + 1))
                    {
                        values[i] = values[i-cut.get(j)] + 1;
                    }
                }
            }

            System.out.println(values[len]);
        }
    }
}