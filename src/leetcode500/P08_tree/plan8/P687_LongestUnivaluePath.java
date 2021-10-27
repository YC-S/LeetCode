package leetcode500.P08_tree.plan8;

public class P687_LongestUnivaluePath {
  int len = 0;

  public int longestUnivaluePath(TreeNode root) {
    if (root == null) return 0;
    dfs(root, root.val);
    return len;
  }

  private int dfs(TreeNode root, int val) {
    if (root == null) return 0;
    int left = dfs(root.left, root.val);
    int right = dfs(root.right, root.val);
    len = Math.max(len, left + right);
    if (val == root.val) return Math.max(left, right) + 1;
    return 0;
  }
}
