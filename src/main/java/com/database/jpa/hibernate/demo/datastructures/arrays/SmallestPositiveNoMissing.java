package com.database.jpa.hibernate.demo.datastructures.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestPositiveNoMissing
{
    public static void main(String[] args)
    {
        int [] arr = {0, -10, 1, 3, -20};
        int min = -21, max = 4;

        for(int i=0; i<arr.length; i++)
        {

            if(0 < arr[i] && arr[i] <= arr.length)
            {
                if(arr[arr[i]] >= 0)
                {
                    arr[arr[i]-1] = (arr[i]) * max + arr[arr[i]-1];
                }
                else
                {
                    arr[arr[i]-1] = (arr[i]) * min + arr[arr[i]-1];
                }
            }
        }

        int solution=0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] > 0)
            {
                if(arr[i] / max > 0)
                {
                    arr[i] = arr[i] % max;
                }
                else
                {
                    if(solution == 0 )
                    solution = i+1;
                }
            }
            else
            {
                if(arr[i] / min > 0)
                {
                    arr[i] = arr[i] % min;
                }
                else
                {
                    if(solution == 0 )
                        solution = i+1;
                }
            }
        }

        System.out.println(solution);
    }

}
