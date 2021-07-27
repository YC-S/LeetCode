package laicode.recursionIII;

public class MaxPathSumFromLeafToRoot {
  public int maxPathSumLeafToRoot(TreeNode root) {
    return helper(root, 0);
  }

  private int helper(TreeNode root, int sum) {
    sum += root.key;
    if (root.left == null && root.right == null) return sum;
    else if (root.left == null) return helper(root.right, sum);
    else if (root.right == null) return helper(root.left, sum);
    return Math.max(helper(root.left, sum), helper(root.right, sum));
  }
}
