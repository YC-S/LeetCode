package leetcode500.P08_tree.plan7;

import java.util.LinkedList;
import java.util.Queue;

public class P117_PopulatingNextRightPointersInEachNodeII {
  public Node connect(Node root) {
    if (root == null) return root;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node cur = queue.poll();
        if (i < size - 1) {
          cur.next = queue.peek();
        }
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
    }
    return root;
  }
}
