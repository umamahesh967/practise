package com.database.jpa.hibernate.demo.datastructures.binarySearch;

public class FindSmallElementIndexInRotatedSortedArray
{
    public  static void main(String[] args)
    {
        int[] a = {11, 12, 14, 15, 17, 18, 19, 20, 1, 3, 5, 7}; //n
        System.out.println(findMin(a, 0, a.length-1));//This algorithm is more readable
        System.out.println(findElementIndex(a, 0, a.length-1));

    }

    //This algorithm is more readable
    static int findMin(int arr[], int low, int high)
    {
        // This condition is needed to handle the case when array
        // is not rotated at all
        if (high < low)  return arr[0];

        // If there is only one element left
        if (high == low) return arr[low];

        // Find mid
        int mid = low + (high - low)/2; /*(low + high)/2;*/

        // Check if element (mid+1) is minimum element. Consider
        // the cases like {3, 4, 5, 1, 2}
        if (mid < high && arr[mid+1] < arr[mid])
            return arr[mid+1];

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];

        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid])
            return findMin(arr, low, mid-1);
        return findMin(arr, mid+1, high);
    }


    //    {11, 12, 14, 15, 17, 18, 19, 20, 1, 3, 5, 7};
    public static int findElementIndex(int[] a, int start, int end)
    {
        if(start < end)
        {
            int mid = (start + end) / 2;

            if(a[mid] > a[mid+1])
            {
                return a[mid+1];
            }

            if(a[start] < a[mid])
            {
                return findElementIndex(a, mid, end);
            }
            else
            {
                return findElementIndex(a,start, mid);
            }
        }
        else
        {
            return a[0];
        }
    }
}
