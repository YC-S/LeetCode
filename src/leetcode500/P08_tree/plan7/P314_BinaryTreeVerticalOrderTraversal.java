package leetcode500.P08_tree.plan7;

import java.util.*;

public class P314_BinaryTreeVerticalOrderTraversal {
  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<Integer> cols = new LinkedList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    queue.offer(root);
    cols.add(0);
    int min = 0;
    int max = 0;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      int col = cols.poll();
      map.putIfAbsent(col, new ArrayList<>());
      map.get(col).add(node.val);
      if (node.left != null) {
        queue.offer(node.left);
        cols.add(col - 1);
        min = Math.min(min, col - 1);
      }
      if (node.right != null) {
        queue.offer(node.right);
        cols.add(col + 1);
        max = Math.max(max, col + 1);
      }
    }
    for (int i = min; i <= max; i++) {
      res.add(map.get(i));
    }
    return res;
  }
}
