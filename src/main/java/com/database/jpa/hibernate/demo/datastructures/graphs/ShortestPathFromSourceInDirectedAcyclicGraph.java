package com.database.jpa.hibernate.demo.datastructures.graphs;
import java.util.*;

/**
 * We can also use djistra algorith instead of this
 */
public class ShortestPathFromSourceInDirectedAcyclicGraph {

  public static void main(String[] args){
    int[][] edges = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
    shortestPath(6, 7, edges);
  }
  public static int[] shortestPath(int N,int M, int[][] edges) {
    //Code here
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    boolean vis[] = new boolean[N];
    Stack<Integer> stk = new Stack<>();
    int[] dis = new int[N];

    for(int i=0; i<N; i++) {
      adj.add(new ArrayList<Pair>());
    }

    for(int[] edge : edges) {
      adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
    }

    for(int i=0; i<N; i++) {
      if(!vis[i]) {
        DFS(i, vis, stk, adj);
      }
    }

    Arrays.fill(dis, (int) (1e8));
    dis[0] = 0;
    boolean found = false;
    while(!stk.isEmpty()) {
      int vert = stk.pop();
      if(found || vert == 0) {
        found = true;
      }
      else{
        // We are not computing the distance for those node which come before the source node,
        // because these nodes come before source node in toposort (i.e there is no directed path from source node to nodes before source node in topo sort)
        continue;
      }
      for(Pair p : adj.get(vert)) {
        if(dis[vert] + p.w < dis[p.v]) {
          dis[p.v] = dis[vert] + p.w;
        }
      }
    }

    for(int i=0; i<N; i++){
      if(dis[i] >= (int) 1e8){
        dis[i] = -1;
      }
    }

    return dis;
  }

  public static void DFS(int v, boolean[] vis, Stack<Integer> stk, ArrayList<ArrayList<Pair>> adj) {
    vis[v] = true;

    for(Pair p : adj.get(v)) {
      if(!vis[p.v]) {
        DFS(p.v, vis, stk, adj);
      }
    }

    stk.push(v);
  }


  static class Pair {
    int v;
    int w;

    Pair(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }

}