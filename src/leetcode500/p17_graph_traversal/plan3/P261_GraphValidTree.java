package leetcode500.p17_graph_traversal.plan3;

import java.util.*;

public class P261_GraphValidTree {
  public boolean validTree(int n, int[][] edges) {
    if (edges == null || edges.length != n - 1) return false;
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
      map.putIfAbsent(edge[0], new ArrayList<>());
      map.putIfAbsent(edge[1], new ArrayList<>());
      map.get(edge[0]).add(edge[1]);
      map.get(edge[1]).add(edge[0]);
    }
    Queue<int[]> queue = new ArrayDeque<>();
    Set<Integer> seen = new HashSet<>();
    int[] pair = new int[] {0, -1};
    queue.add(pair);
    seen.add(0);
    while (!queue.isEmpty()) {
      pair = queue.poll();
      int cur = pair[0];
      int parent = pair[1];
      for (int nbr : map.getOrDefault(cur, new ArrayList<>())) {
        if (nbr == parent) continue;
        if (seen.contains(nbr)) return false;
        seen.add(nbr);
        queue.add(new int[] {nbr, cur});
      }
    }
    return seen.size() == n;
  }
}
