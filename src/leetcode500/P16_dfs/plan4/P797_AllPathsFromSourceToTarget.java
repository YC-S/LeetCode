package leetcode500.P16_dfs.plan4;

import java.util.ArrayList;
import java.util.List;

public class P797_AllPathsFromSourceToTarget {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    path.add(0);
    dfs(graph, 0, res, path);

    return res;
  }

  private void dfs(int[][] graph, int node, List<List<Integer>> res, List<Integer> cur) {
    if (node == graph.length - 1) {
      res.add(new ArrayList<>(cur));
      return;
    }

    for (int nextNode : graph[node]) {
      cur.add(nextNode);
      dfs(graph, nextNode, res, cur);
      cur.remove(cur.size() - 1);
    }
  }
}
