package leetcode500.P08_tree.plan6;

import java.util.LinkedList;
import java.util.Queue;

public class P958_CheckCompletenessOfABinaryTree {
  public boolean isCompleteTree(TreeNode root) {
    boolean seen = false;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if (cur == null) seen = true;
      else {
        if (seen) return false;
        queue.add(cur.left);
        queue.add(cur.right);
      }
    }
    return true;
  }
}
