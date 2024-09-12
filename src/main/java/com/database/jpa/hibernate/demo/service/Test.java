package com.database.jpa.hibernate.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test {
    public static void main(String[] args){
        new StaticTest().populateList();
    }
}

class StaticTest {
    public List<Double> list = new ArrayList<>();

    public void populateList() {
        for (int i = 0; i < 10000000; i++) {
            list.add(Math.random());
        }
        System.out.println("Debug Point 2");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Debug Point 1");
        new StaticTest().populateList();
        System.out.println("Debug Point 3");
        Thread.sleep(10000000);
    }
}

class Solution {
    public static void main(String[] args) {
        int[] fruits = {0,1,2,2};
        Map<Integer, Integer> map = new HashMap<>();
        int start =0, len=fruits.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<len; i++){
            if(map.size() < 2 || map.containsKey(fruits[i])){
                map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
                System.out.println("inside" + i+ "   ");
            }
            else{
                System.out.println(i+ "   ");
                while(map.size() == 2){
                    if(map.get(fruits[start]) > 1){
                        map.put(fruits[start], map.get(fruits[start])-1);
                    }
                    else{
                        map.remove(fruits[start]);
                    }
                    start++;
                }
                map.put(fruits[i], 1);
            }

            if(max < (i-start+1)){
                System.out.println(i+"   "+start+"  " + (i-start+1));
                max=i-start+1;
            }
        }
        return;
    }
}