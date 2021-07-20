package laicode.cross_trainingI;

import java.util.ArrayDeque;
import java.util.Deque;

public class ClosestNumberInBSTII {
  public int[] closestKValues(TreeNode root, double target, int k) {
    // Write your solution here
    Deque<Integer> deque = new ArrayDeque<>();
    int[] cur = new int[] {k};
    helper(root, target, deque, cur);
    int[] res = new int[deque.size()];
    int size = deque.size();
    for (int i = 0; i < size; i++) {
      res[i] = deque.poll();
    }
    return res;
  }

  private void helper(TreeNode root, double target, Deque<Integer> deque, int[] k) {
    if (root == null) {
      return;
    }
    helper(root.left, target, deque, k);
    if (k[0] > 0) {
      deque.offerLast(root.key);
      k[0]--;
    } else {
      if (Math.abs(deque.peekFirst() - target) > Math.abs(root.key - target)) {
        deque.pollFirst();
        deque.offerLast(root.key);
      } else {
        return;
      }
    }
    helper(root.right, target, deque, k);
  }
}
