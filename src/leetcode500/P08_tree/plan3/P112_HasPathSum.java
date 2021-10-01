package leetcode500.P08_tree.plan3;

public class P112_HasPathSum {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;
    targetSum -= root.val;
    if (root.left == null && root.right == null) return targetSum == 0;
    return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
  }
}
