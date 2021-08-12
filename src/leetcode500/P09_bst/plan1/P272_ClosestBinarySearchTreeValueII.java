package leetcode500.P09_bst.plan1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P272_ClosestBinarySearchTreeValueII {
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    Deque<Integer> deque = new ArrayDeque<>();
    inorder(deque, root, target, k);
    return new ArrayList<>(deque);
  }

  private void inorder(Deque<Integer> deque, TreeNode node, double target, int k) {
    if (node == null) return;
    inorder(deque, node.left, target, k);
    double val = node.val;
    if (deque.size() == k) {
      if (Math.abs(deque.peekFirst() - target) > Math.abs(val - target)) {
        deque.pollFirst();
        deque.offerLast(node.val);
      } else return;
    } else {
      deque.offerLast(node.val);
    }
    inorder(deque, node.right, target, k);
  }
}
