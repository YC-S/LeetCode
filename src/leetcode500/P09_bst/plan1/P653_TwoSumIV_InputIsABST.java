package leetcode500.P09_bst.plan1;

import java.util.HashSet;
import java.util.Set;

public class P653_TwoSumIV_InputIsABST {
  public boolean findTarget(TreeNode root, int k) {
    Set<Integer> set = new HashSet<>();
    return find(root, k, set);
  }

  private boolean find(TreeNode root, int k, Set<Integer> set) {
    if (root == null) return false;
    if (set.contains(k - root.val)) return true;
    set.add(root.val);
    return find(root.left, k, set) || find(root.right, k, set);
  }
}
