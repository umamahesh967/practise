package com.database.jpa.hibernate.demo.generalPractise;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SumOfFourNumbers
{
    public static void main(String[] args) {
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();

        int arr[] = {10, 2, 3, 4, 5, 7, 8};

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int sum = arr[i] + arr[j];

                if (map.containsKey(sum)) {
                    map.get(sum).add(new Pair<>(arr[i], arr[j]));
                } else {
                    List<Pair<Integer, Integer>> list = new ArrayList<>();
                    list.add(new Pair<Integer, Integer>(arr[i], arr[j]));
                    map.put(sum, list);
                }
            }
        }
        map = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (pairs, pairs2) -> pairs, LinkedHashMap::new));


        int sum = 23;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int mid = arr[i] + arr[j];

                List<Pair<Integer, Integer>> list = map.get(sum - mid);
                if (list != null) {
//                    for (Iterator<Pair<Integer, Integer>> iterator = list.iterator(); iterator.hasNext(); )
//                    {
//                        Pair<Integer, Integer> pair = iterator.next();
//
//
//                    }
                }
            }
        }
    }
}
