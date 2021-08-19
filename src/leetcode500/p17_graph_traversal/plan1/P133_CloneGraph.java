package leetcode500.p17_graph_traversal.plan1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class P133_CloneGraph {
  Map<Node, Node> visited = new HashMap<Node, Node>();

  public Node cloneGraph(Node node) {
    if (node == null) return null;
    if (visited.containsKey(node)) return visited.get(node);
    Node cloneNode = new Node(node.val, new ArrayList<>());
    visited.put(node, cloneNode);
    for (Node neighbor : node.neighbors) {
      cloneNode.neighbors.add(cloneGraph(neighbor));
    }
    return cloneNode;
  }
}
