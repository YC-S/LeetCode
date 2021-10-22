package leetcode500.P08_tree.plan6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P429_NAryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> curList = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        Node cur = queue.poll();
        curList.add(cur.val);
        for (Node child : cur.children) {
          if (child != null) {
            queue.offer(child);
          }
        }
      }
      res.add(curList);
    }
    return res;
  }
}
