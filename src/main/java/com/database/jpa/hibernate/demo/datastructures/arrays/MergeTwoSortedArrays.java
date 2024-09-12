package com.database.jpa.hibernate.demo.datastructures.arrays;

public class MergeTwoSortedArrays
{
    public  static void main(String[] args)
    {
        int[] a = {1, 3, 5, 7}; //n
        int[] b = {0, 2, 6, 8, 9}; //m

        withOutSpaceInsertionSort(a,b); //Time Complexity O(nm)
        System.out.println();

        int[] a1 = { 10, 27, 38, 43 ,82 }; //n
        int[] a2 = { 3,9 }; //m

        /**
         * reference
         * https://www.geeksforgeeks.org/efficiently-merging-two-sorted-arrays-with-o1-extra-space/?ref=rp
         */
        gapAlgorithm(a1, a2); //O((n+m)*log(n+m))
        System.out.println();

    }

    public static void gapAlgorithm(int[] a, int[] b)
    {
        int gap = a.length + b.length;


        while(gap > 1)
        {
            gap = (gap +1)/2; //Take always ceil

            int i =0, j= gap;

            while((i < a.length + b.length && j < a.length + b.length))
            {
                if(i < a.length && j<a.length)
                {
                    if(a[i] > a[j])
                    {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
                else if(i < a.length && j >= a.length)
                {
                    if(a[i] > b[j-a.length])
                    {
                        int temp = a[i];
                        a[i] = b[j-a.length];
                        b[j-a.length] = temp;
                    }
                }
                else
                {
                    if(b[i-a.length] > b[j-a.length])
                    {
                        int temp = b[i-a.length];
                        b[i-a.length] = b[j-a.length];
                        b[j-a.length] = temp;
                    }
                }
                i++;
                j++;
            }
        }
    }

    public static void withOutSpaceInsertionSort(int[] a, int[] b)
    {
        if(a.length > b.length)
        {
            int[] c = a;
            a = b;
            b = c;
        }

        int len1 = a.length-1, len2 = b.length-1;

        while(len1 >=0 && len2>=0)
        {
            if(a[len1] > b[len2])
            {
                int temp = b[len2];
                b[len2] = a[len1];

                int k = len1;

                //Keeping the element in correct place.
                while(k-1 >=0 && a[k-1] > temp)
                {
                    a[k] = a[k-1];
                    k--;
                }
                a[k] = temp;
                len2--;
            }
            else
            {
                len2--;
            }
        }
    }

}
