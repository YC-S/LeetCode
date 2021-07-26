package laicode.cross_trainingIII;

import java.util.*;

public class Bipartite {
  public boolean isBipartite(List<GraphNode> graph) {
    Map<GraphNode, Integer> visited = new HashMap<>();
    for (GraphNode node : graph) {
      if (!BFS(node, visited)) return false;
    }
    return true;
  }

  private boolean BFS(GraphNode node, Map<GraphNode, Integer> visited) {
    if (visited.containsKey(node)) return true;
    Queue<GraphNode> queue = new LinkedList<>();
    queue.offer(node);
    visited.put(node, 0);
    while (!queue.isEmpty()) {
      GraphNode cur = queue.poll();
      int curGroup = visited.get(cur);
      int neiGroup = curGroup == 0 ? 1 : 0;
      for (GraphNode nei : cur.neighbors) {
        if (!visited.containsKey(nei)) {
          visited.put(nei, neiGroup);
          queue.offer(nei);
        } else if (visited.get(nei) != neiGroup) return false;
      }
    }
    return true;
  }
}
