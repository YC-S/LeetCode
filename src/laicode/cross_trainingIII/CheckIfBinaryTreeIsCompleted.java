package laicode.cross_trainingIII;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfBinaryTreeIsCompleted {
  public boolean isComplete(TreeNode root) {
    if (root == null) return true;
    Queue<TreeNode> queue = new LinkedList<>();
    boolean flag = false;
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if (cur.left == null) flag = false;
      else if (flag == true) return false;
      else queue.offer(cur.left);
      if (cur.right == null) flag = true;
      else if (flag == true) return false;
      else queue.offer(cur.right);
    }
    return true;
  }
}
