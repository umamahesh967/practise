package com.database.jpa.hibernate.demo.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/***
 * DetectCycleInDirectedGraph
 * With Cycle is called Cyclic Graph
 * Without cycle in graph is called - Directed Acyclic Graph (DAG)
 */
public class DetectCycleInUnDirectedGraph {

  /***
   * Using KAHN's Algorithms
   * This Algorithm works only for Directed Graph and uses BFS.
   * https://www.youtube.com/watch?v=73sneFXuTEg
   * Time Complexity:- O(V+E)
   * Space Complexity:- O(N)
   */
  public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> graph) {
    // code here
    int[] inDegree = new int[V];
    Queue<Integer> queue = new LinkedList<>();

    for (ArrayList<Integer> edge : graph) {
      for (Integer node : edge) {
        inDegree[node]++;
      }
    }

    for (int i = 0; i < V; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
      }
    }

    int visited = 0;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      visited++;
      for (Integer edge : graph.get(node)) {
        inDegree[edge]--;
        if (inDegree[edge] == 0) {
          queue.add(edge);
        }
      }
    }

    if (visited == V) {
      return false;
    }
    return true;
  }



  /**
   * Solution 2
   * Normal DFS Solution
   * Time Complexity:- O(V+E)
   * Space Complexity:- O(N)
   */
  public boolean isCyclic2(int V, ArrayList<ArrayList<Integer>> adj) {
    // code here
    Set<Integer> set = new HashSet<>();
    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if (detectLoop(i, adj, set, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean detectLoop(int vertex,
      ArrayList<ArrayList<Integer>> adj,
      Set<Integer> set, boolean[] visited) {
    visited[vertex] = true;
    ArrayList<Integer> list = adj.get(vertex);
    set.add(vertex);
    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()) {
      int num = iterator.next();

      if (visited[num] && set.contains(num)) {
        return true;
      }

      if (!visited[num]) {
        if (detectLoop(num, adj, set, visited)) {
          return true;
        }
      }
    }

    set.remove(vertex);
    return false;
  }
}
