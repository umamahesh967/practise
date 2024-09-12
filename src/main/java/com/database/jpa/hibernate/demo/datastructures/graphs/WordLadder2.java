package com.database.jpa.hibernate.demo.datastructures.graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 */
public class WordLadder2 {

  public static void main(String[] args) {
    int[][] edges = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};
    List<String> wordList = new ArrayList<>();
    wordList.add("des");
    wordList.add("der");
    wordList.add("dfr");
    wordList.add("dgt");
    wordList.add("dfs");
    findLadders("der", "dfs", wordList);
  }

  public static List<List<String>> findLadders(String startWord, String targetWord, List<String> wordList) {
    // Code here
    Set<String> set = new HashSet();
    for (String word : wordList) {
      set.add(word);
    }

    Queue<String> queue = new LinkedList<>();
    queue.add(startWord);
    set.remove(startWord);

    Map<String, Integer> map = new HashMap<>();
    int level = 1;
    map.put(startWord, level);
    while (!queue.isEmpty()) {
      int size = queue.size(), k = 0;
      boolean breakLoop = false;
      while (k < size) {
        String word = queue.poll();

        if (word.equals(targetWord)) {
          breakLoop = true;
          break;
        }

        for (int i = 0; i < word.length(); i++) {
          char[] array = word.toCharArray();
          for (char ch = 'a'; ch <= 'z'; ch++) {
            array[i] = ch;
            String nextWord = new String(array);
            if (set.contains(nextWord)) {
              queue.add(nextWord);
              set.remove(nextWord);
              map.put(nextWord, level+1);
            }
          }
          array[i] = word.charAt(i);
        }
        k++;
      }
      if (breakLoop) {
        break;
      }
      level++;
    }

    List<List<String>> result = new ArrayList<>();
    if(!map.containsKey(targetWord)) return result;
    dfs(result, map, targetWord, new ArrayList<>());
    result.stream().forEach(subList -> Collections.reverse(subList));
    return result;
  }

  private static void dfs(List<List<String>> result, Map<String, Integer> map,
      String word, ArrayList<String> sequence) {
    sequence.add(word);
    if(map.get(word)== 1) {
      result.add(new ArrayList<>(sequence));
      sequence.remove(sequence.size()-1);
      return;
    }
    for (int i = 0; i < word.length(); i++) {
      char[] array = word.toCharArray();
      for (char ch = 'a'; ch <= 'z'; ch++) {
        array[i] = ch;
        String nextWord = new String(array);
        if (map.containsKey(nextWord) && map.get(nextWord)+1 == map.get(word)) {
          dfs(result, map, nextWord, sequence);
        }
      }
    }
    sequence.remove(sequence.size()-1);
  }
}
