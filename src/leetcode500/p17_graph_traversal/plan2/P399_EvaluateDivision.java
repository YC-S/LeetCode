package leetcode500.p17_graph_traversal.plan2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P399_EvaluateDivision {
  public double[] calcEquation(
      List<List<String>> equations, double[] values, List<List<String>> queries) {

    double[] ans = new double[queries.size()];
    Graph g = new Graph();
    g.buildGraph(equations, values);
    for (int i = 0; i < queries.size(); i++) {
      String start = queries.get(i).get(0);
      String end = queries.get(i).get(1);
      ans[i] = dfs(g.graph, start, end, 1.0);
      g.resetState();
    }

    return ans;
  }

  public double dfs(HashMap<String, GraphNode> g, String s, String e, double product) {
    if (!g.containsKey(s) || !g.containsKey(e)) return -1.0;

    if (s.equals(e)) return product;

    GraphNode start = g.get(s);
    if (start.state != 1) {
      start.state = 1;
      for (Map.Entry<GraphNode, Double> entry : start.outedges.entrySet()) {
        if (entry.getKey().state == 0) {
          double ans = dfs(g, entry.getKey().val, e, product * entry.getValue());
          if (ans > -1) {
            return ans;
          }
        }
      }
    }

    return -1;
  }

  static class GraphNode {
    String val;
    int state;
    HashMap<GraphNode, Double> outedges;

    public GraphNode(String val) {
      this.val = val;
      state = 0;
      outedges = new HashMap<>();
    }
  }

  static class Graph {
    HashMap<String, GraphNode> graph;

    public Graph() {
      graph = new HashMap<>();
    }

    public void buildGraph(List<List<String>> equations, double[] values) {
      for (int i = 0; i < equations.size(); i++) {
        String node1 = equations.get(i).get(0);
        String node2 = equations.get(i).get(1);
        graph.putIfAbsent(node1, new GraphNode(node1));
        graph.putIfAbsent(node2, new GraphNode(node2));
        graph.get(node1).outedges.put(graph.get(node2), values[i]);
        graph.get(node2).outedges.put(graph.get(node1), 1.0 / values[i]);
      }
    }

    public void resetState() {
      for (Map.Entry<String, GraphNode> e : graph.entrySet()) {
        e.getValue().state = 0;
      }
    }
  }
}
