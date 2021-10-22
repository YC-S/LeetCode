package leetcode500.P08_tree.plan6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P107_BinaryTreeLevelOrderTraversalII {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> curList = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        curList.add(cur.val);
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
      res.add(0, curList);
    }
    return res;
  }
}
