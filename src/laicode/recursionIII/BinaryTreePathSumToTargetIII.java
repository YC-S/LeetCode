package laicode.recursionIII;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSumToTargetIII {
  public boolean exist(TreeNode root, int target) {
    boolean[] flag = new boolean[] {false};
    List<Integer> set = new ArrayList<>();
    set.add(0);
    helper(root, target, flag, set, 0);
    return flag[0];
  }

  private void helper(TreeNode root, int target, boolean[] flag, List<Integer> set, int prefixSum) {
    if (root == null) return;
    set.add(prefixSum + root.key);
    if (set.contains(prefixSum + root.key - target)) flag[0] = true;
    helper(root.left, target, flag, set, prefixSum + root.key);
    helper(root.right, target, flag, set, prefixSum + root.key);
    set.remove(set.size() - 1);
  }
}
