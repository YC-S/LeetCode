package leetcode500.p17_graph_traversal.plan1;

import java.util.ArrayList;
import java.util.List;

public class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<>();
  }

  public Node(int val) {
    this.val = val;
    neighbors = new ArrayList<>();
  }

  public Node(int val, ArrayList<Node> neighbors) {
    this.val = val;
    this.neighbors = neighbors;
  }
}
