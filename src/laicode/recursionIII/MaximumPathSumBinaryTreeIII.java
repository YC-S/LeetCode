package laicode.recursionIII;

public class MaximumPathSumBinaryTreeIII {
  public int maxPathSum(TreeNode root) {
    int[] max = new int[] {Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
  }

  private int helper(TreeNode root, int[] max) {
    if (root == null) return 0;
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    int sin = Math.max(Math.max(left, right), 0) + root.key;
    max[0] = Math.max(sin, max[0]);
    return sin;
  }
}
