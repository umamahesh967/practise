package com.database.jpa.hibernate.demo.swagger;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

class HelloWorld {

  public static void main(String[] args) {
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int[] nums = new int[2];
    Arrays.stream(nums).boxed().collect(Collectors.toList());
    return 0;
  }
  public int[][] merge(int[][] intervals) {
    Comparator<int[]> comp = (a, b) -> a[0] - b[0];
    Arrays.sort(intervals, comp);

    int start=0;
    for(int i=1; i<intervals.length; i++){
      if(intervals[start][1] >= intervals[i][0]){
        intervals[start][1] = Math.max(intervals[start][1], intervals[i][1]);
      }
      else{
        start++;
        intervals[start][0] = intervals[i][0];
        intervals[start][1] = intervals[i][1];
      }
    }
    int[][] arr = new int[start+1][2];
    for(int i=0; i<start+1; i++){
      arr[i][0] = intervals[i][0];
      arr[i][1] = intervals[i][1];
    }
    return arr;
  }
}
