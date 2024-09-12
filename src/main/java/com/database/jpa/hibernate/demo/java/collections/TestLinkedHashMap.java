package com.database.jpa.hibernate.demo.java.collections;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Insertion operation in LinkedHashMap is O(1)
 * For maintaining the insertion order LinkedHashMap uses Head and Tail pointers for Doubly Linked List.
 * Head and Tail pointers are of type LinkedHashMap.Entry<K,V>.
 * <p>
 * HashMap maintains Node<K,V>[]
 * <p>
 * LinkedHashMap.Entry<K,V> implements Node<K,V>.
 * <p>
 * When we call put on LinkedHashMap we create a node of LinkedHashMap.Entry<K,V> and put it in HashMap Node array
 * an also add the reference in tail of LinkedHashMap.
 * <p>
 * So put and get, remove operations are of O(1).
 */
public class TestLinkedHashMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(2, 3);
        map.put(5, 6);
        map.put(7, 8);
        map.put(7, 9);
        map.put(0, 1);

        System.out.println(map.keySet().stream().findFirst().get());
        Random random = new Random(5);
        System.out.println((int) Math.floor(Math.random() * (5 - 1 + 1)) + 1);
        IntStream.of(10).forEach(a -> {
            System.out.println();
        });
        longestIncreasingPath();
    }

    public static void longestIncreasingPath() {
        int matrix[][] = {{1, 2, 3, 4, 6},
                {5, 3, 8, 1, 2},
                {4, 6, 7, 5, 5},
                {2, 4, 8, 9, 4}};

        int aux[][] = new int[4][5];
        aux[0][0] = matrix[0][0];
        for(int i=1; i<5; i++){
            aux[0][i] = aux[0][i-1] + matrix[0][i];
        }

        for(int i=1; i<4; i++){
            aux[i][0] = aux[i-1][0] + matrix[i][0];
        }

        for(int i=1; i<4; i++){
            for(int j=1; j<5; j++){
                aux[i][j] = aux[i-1][j] - aux[i-1][j-1] + aux[i][j-1] + matrix[i][j];
            }
        }

        System.out.println();
    }


}

class treeMap {
//    public static void main(String[] args) {
//        System.out.println("the main");
//        byValue cmp = new byValue();
//        Map<String, Integer> map = new TreeMap<String, Integer>(cmp);
//        map.put("de", 10);
//        map.put("ab", 20);
//        map.put("a", 5);
//
//        for (Map.Entry<String, Integer> pair : map.entrySet()) {
//            System.out.println(pair.getKey() + ":" + pair.getValue());
//        }
//    }
}

class byValue implements Comparator<Map.Entry<String, Integer>> {
    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        if (e1.getValue() < e2.getValue()) {
            return 1;
        } else if (e1.getValue() == e2.getValue()) {
            return 0;
        } else {
            return -1;
        }
    }
}