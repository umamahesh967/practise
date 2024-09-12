package com.database.jpa.hibernate.demo.datastructures.heap;

import java.util.PriorityQueue;

public class KthLargestElement
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{3,6,8,2,7,319,35};
        int k =4;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i=0; i<k; i++)
        {
            priorityQueue.add(arr[i]);
        }

        for(int i=k; i<arr.length; i++)
        {
            if(arr[i] > priorityQueue.peek())
            {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
                System.out.println(priorityQueue.peek());
            }
            else
            {
                System.out.println(priorityQueue.peek());
            }
        }
    }
}
