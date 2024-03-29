package leetcode500.P08_tree.plan5;

public class P98_ValidateBinarySearchTree {
  public boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean helper(TreeNode root, long min, long max) {
    if (root == null) return true;
    if (root.val <= min || root.val >= max) return false;
    return helper(root.left, min, root.val) && helper(root.right, root.val, max);
  }
}
