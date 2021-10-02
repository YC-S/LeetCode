package leetcode500.P09_bst.plan3;

import java.util.ArrayDeque;
import java.util.Deque;

public class P255_VerifyPreorderSequenceInBST {
  public boolean verifyPreorder(int[] preorder) {
    if (preorder.length == 0) return true;
    int max = Integer.MIN_VALUE;
    Deque<Integer> stack = new ArrayDeque<>();
    stack.offerFirst(preorder[0]);
    for (int i = 1; i < preorder.length; i++) {
      int val = preorder[i];
      if (val < max) return false;
      if (val < stack.peekFirst()) {
        stack.offerFirst(val);
      } else {
        while (stack.size() > 0 && val > stack.peekFirst()) {
          max = Math.max(max, stack.pollFirst());
        }
        stack.offerFirst(val);
      }
    }
    return true;
  }
}
