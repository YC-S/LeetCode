package leetcode500.P08_tree.plan6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P637_AverageOfLevelsInBinaryTree {
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> res = new ArrayList<>();
    if (root == null) return res;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      double sum = 0;
      double count = 0;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        sum += cur.val;
        count++;
        if (cur.left != null) queue.offer(cur.left);
        if (cur.right != null) queue.offer(cur.right);
      }
      res.add(sum / count);
    }
    return res;
  }
}
