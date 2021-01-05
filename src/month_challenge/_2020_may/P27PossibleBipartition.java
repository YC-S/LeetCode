/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/05/27
 */
public class P27PossibleBipartition {

  List<Integer>[] adj;
  Map<Integer, Integer> color;

  public boolean possibleBipartition(int N, int[][] dislikes) {
    adj = new ArrayList[N + 1];
    for (int i = 1; i <= N; ++i) {
      adj[i] = new ArrayList();
    }

    for (int[] edge : dislikes) {
      adj[edge[0]].add(edge[1]);
      adj[edge[1]].add(edge[0]);
    }

    color = new HashMap();
    for (int i = 1; i <= N; i++) {
      if (!color.containsKey(i) && !dfs(i, 0)) {
        return false;
      }
    }
    return true;
  }

  public boolean dfs(int node, int c) {
    if (color.containsKey(node)) {
      return color.get(node) == c;
    }
    color.put(node, c);

    for (int nei : adj[node]) {
      if (!dfs(nei, c ^ 1)) {
        return false;
      }
    }
    return true;
  }
}
