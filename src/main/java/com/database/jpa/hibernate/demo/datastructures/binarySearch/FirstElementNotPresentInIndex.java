package com.database.jpa.hibernate.demo.datastructures.binarySearch;

public class FirstElementNotPresentInIndex
{
    public  static void main(String[] args)
    {
        int[] a = {1,2,3,4,6,7,8};

        System.out.println(findElement(a, 0, a.length-1));
    }

    private static int findElement(int[] a, int start, int end)
    {
        if(start > end)
        {
            return -1;
        }

        if(start == end)
        {
            return start+1;
        }

        int mid = (start + end)/2;

        if(a[mid] == mid+1)
        {
            return findElement(a, mid+1, end);
        }
        else
        {
            return findElement(a, start, mid);
        }
    }
}
