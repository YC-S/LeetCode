package laicode.cross_trainingII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepCopyUndirectedGraph {
  public List<GraphNode> copy(List<GraphNode> graph) {
    if (graph == null) return null;
    Map<GraphNode, GraphNode> map = new HashMap<>();
    for (GraphNode node : graph) {
      if (!map.containsKey(node)) {
        map.put(node, new GraphNode(node.key));
        DFS(node, map);
      }
    }
    return new ArrayList<>(map.values());
  }

  private void DFS(GraphNode seed, Map<GraphNode, GraphNode> map) {
    GraphNode copy = map.get(seed);
    for (GraphNode neighbor : seed.neighbors) {
      if (!map.containsKey(neighbor)) {
        map.put(neighbor, new GraphNode(neighbor.key));
        DFS(neighbor, map);
      }
      copy.neighbors.add(map.get(neighbor));
    }
  }
}
