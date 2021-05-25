package all_problems;

import java.util.Arrays;

public class P1756_DesignMostRecentlyUsedQueue {
  Node[] nodes;
  int bucket;

  public P1756_DesignMostRecentlyUsedQueue(int n) {
    bucket = (int) Math.sqrt(n);
    nodes = new Node[(n + bucket - 1) / bucket];
    Arrays.asList(nodes).replaceAll(i -> new Node(-1));
    for (int i = 1; i <= n; i++) {
      nodes[(i - 1) / bucket].prev.append(new Node(i));
    }
  }

  public int fetch(int k) {
    Node ans = nodes[--k / bucket].next;
    for (int i = k % bucket; i > 0; i--) {
      ans = ans.next;
    }
    ans.remove();
    for (int i = 1 + k / bucket; i < nodes.length; i++) {
      nodes[i - 1].prev.append(nodes[i].next.remove());
    }
    nodes[nodes.length - 1].prev.append(ans);
    return ans.val;
  }

  static class Node {
    Node prev = this;
    Node next = this;
    int val;

    Node(int val) {
      this.val = val;
    }

    void append(Node node) {
      Node tmp = next;
      next = node;
      node.prev = this;
      node.next = tmp;
      tmp.prev = node;
    }

    Node remove() {
      prev.next = next;
      next.prev = prev;
      return next = prev = this;
    }
  }
}
