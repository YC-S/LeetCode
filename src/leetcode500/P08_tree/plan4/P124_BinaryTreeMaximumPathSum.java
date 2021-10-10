package leetcode500.P08_tree.plan4;

public class P124_BinaryTreeMaximumPathSum {
  public int maxPathSum(TreeNode root) {
    int[] res = {Integer.MIN_VALUE};
    dfs(root, res);
    return res[0];
  }

  private int dfs(TreeNode root, int[] res) {
    if (root == null) return 0;
    int left = Math.max(0, dfs(root.left, res));
    int right = Math.max(0, dfs(root.right, res));
    res[0] = Math.max(left + right + root.val, res[0]);
    return Math.max(left, right) + root.val;
  }
}
