package leetcode500.P08_tree.plan6;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P103_BinaryTreeZigzagLevelOrderTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.offerLast(root);
    boolean toRight = true;
    while (!deque.isEmpty()) {
      int size = deque.size();
      List<Integer> curList = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        if (toRight) {
          TreeNode cur = deque.pollFirst();
          curList.add(cur.val);
          if (cur.left != null) {
            deque.offerLast(cur.left);
          }
          if (cur.right != null) {
            deque.offerLast(cur.right);
          }
        } else {
          TreeNode cur = deque.pollLast();
          curList.add(cur.val);
          if (cur.right != null) {
            deque.offerFirst(cur.right);
          }
          if (cur.left != null) {
            deque.offerFirst(cur.left);
          }
        }
      }
      toRight = !toRight;
      res.add(curList);
    }
    return res;
  }
}
