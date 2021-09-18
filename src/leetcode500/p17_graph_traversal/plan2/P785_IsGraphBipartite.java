package leetcode500.p17_graph_traversal.plan2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P785_IsGraphBipartite {
  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] color = new int[n];
    Arrays.fill(color, -1);

    for (int start = 0; start < n; ++start) {
      if (color[start] == -1) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(start);
        color[start] = 0;

        while (!stack.isEmpty()) {
          Integer node = stack.pollFirst();
          for (int nei : graph[node]) {
            if (color[nei] == -1) {
              stack.offerFirst(nei);
              color[nei] = color[node] ^ 1;
            } else if (color[nei] == color[node]) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }
}
