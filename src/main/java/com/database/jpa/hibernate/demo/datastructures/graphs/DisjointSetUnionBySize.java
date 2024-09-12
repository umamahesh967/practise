package com.database.jpa.hibernate.demo.datastructures.graphs;

import java.util.Arrays;

/**
 * In Union By size, we use size
 * https://www.geeksforgeeks.org/disjoint-set-data-structures/
 */
public class DisjointSetUnionBySize {

  int[] size, parent;
  int n;

  // Constructor
  public DisjointSetUnionBySize(int n) {
    //0 indexed nodes/vertices
    size = new int[n];
    parent = new int[n];
    this.n = n;
    Arrays.fill(size, 1);
    makeSet();
  }

  // Creates n sets with single item in each
  void makeSet() {
    for (int i = 0; i < n; i++) {
      // Initially, all elements are in
      // their own set.
      parent[i] = i;
    }
  }

  // Returns representative of x's set
  int find(int x) {
    // Finds the representative of the set
    // that x is an element of
    if (parent[x] != x) {
      // if x is not the parent of itself
      // Then x is not the representative of
      // his set,
      parent[x] = find(parent[x]);

      // so we recursively call Find on its parent
      // and move i's node directly under the
      // representative of this set
    }

    return parent[x];
  }

  // Unites the set that includes x and the set
  // that includes x
  void union(int x, int y) {
    // Find representatives of two sets
    int xRoot = find(x), yRoot = find(y);

    // Elements are in the same set, no need
    // to unite anything.
    if (xRoot == yRoot) {
      return;
    }

    // If x's size is less than y's size
    if (size[xRoot] < size[yRoot])

    // Then move x under y  so that depth
    // of tree remains less
    {
      parent[xRoot] = yRoot;
      size[yRoot] += size[xRoot];
    }

    // Else if y's size is less than x's size
    else if (size[yRoot] < size[xRoot])

    // Then move y under x so that depth of
    // tree remains less
    {
      parent[yRoot] = xRoot;
      size[xRoot] += size[yRoot];
    } else // if sizes are the same
    {
      // Then move y under x (doesn't matter
      // which one goes where)
      parent[yRoot] = xRoot;

      size[xRoot] += size[yRoot];
    }
  }
}

// Driver code
class Main1 {

  public static void main(String[] args) {
    // Let there be 5 persons with ids as
    // 0, 1, 2, 3 and 4
    int n = 5;
    DisjointSetUnionBySize dus =
        new DisjointSetUnionBySize(n);

    // 0 is a friend of 2
    dus.union(0, 2);

    // 4 is a friend of 2
    dus.union(4, 2);

    // 3 is a friend of 1
    dus.union(3, 1);

    // Check if 4 is a friend of 0
    if (dus.find(4) == dus.find(0)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

    // Check if 1 is a friend of 0
    if (dus.find(1) == dus.find(0)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
