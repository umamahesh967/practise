package com.database.jpa.hibernate.demo.generalPractise;

public class Maximum
{
    public static void main(String[] args)
    {
        int[][] arr = new int[3][3];

        int len = arr.length;
        int sum = 0;
        for(int i = len - 1; i >= 0; i--)
        {
            sum += arr[len - 1][i];
            arr[len - 1][i] = sum;
        }

        sum = 0;
        for(int i = len - 1; i >= 0; i--)
        {
            sum += arr[i][len - 1];
            arr[i][len - 1] = sum;
        }

        for(int i=len - 2; i>=0; i--)
        {
            for(int j=len - 2; j>=0; j--)
            {
                arr[i][j] += Math.max(arr[i-1][j-1], Math.max(arr[i-1][j],arr[i][j-1]));
            }
        }

        System.out.println(arr[0][len-1]);
    }
}
