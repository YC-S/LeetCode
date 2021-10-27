package leetcode500.P08_tree.plan7;

public class P404_SumOfLeftLeaves {
  public int sumOfLeftLeaves(TreeNode root) {
    return helper(root, false);
  }

  private int helper(TreeNode root, boolean left) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) {
      if (left) return root.val;
      else return 0;
    }
    return helper(root.left, true) + helper(root.right, false);
  }
}
