package com.database.jpa.hibernate.demo.generalPractise.dp;

import java.util.List;

//Text Justification (or) Word wrap Problem
public class TextJustification
{
    public static void main(String[] args)
    {
        new Solution().fullJustify(new String[]{"Tushar", "Roy", "likes", "to", "code"}, 10);
    }
}

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth)
    {
        int len = words.length;
        int[][] arr = new int[len][len];

        for(int i=0; i<len; i++)
        {
            int sum = 0;
            for(int j=i; j<len; j++)
            {
                sum += words[j].length();
                if(sum > maxWidth)
                {
                    arr[i][j] = Integer.MAX_VALUE;
                }
                else
                {
                    int space = maxWidth - sum;
                    arr[i][j] = space * space;
                }
                sum += 1;
            }
        }

        int[] space = new int[len];
        for(int i=0; i<len; i++)
        {
            space[i] = Integer.MAX_VALUE;
        }
        int[] split = new int[len];

        for(int i=len-1; i>=0; i--)
        {
            int cost = Integer.MAX_VALUE;
            int end = len-1;
            for(int j=len-1; j>=i; j--)
            {
                if(arr[i][j] != Integer.MAX_VALUE)
                {
                    if(j == len-1)
                    {
                        cost = arr[i][j];
                        break;
                    }
                    else
                    {
                        if(arr[i][j] + space[j+1] < cost)
                        {
                            cost = arr[i][j] + space[j+1];
                            end = j;
                        }
                    }
                }
            }
            split[i] = end;
            space[i] = cost;
        }

        int i=0;
        while(i<len)
        {
            int i1= i;
            for(i = i1; i1 <= split[i]; i1++)
            {
                System.out.print(words[i1] + " ");
            }
            System.out.println();
            i = i1;
        }
        return null;
    }
}