package leetcode500.P08_tree.plan8;

public class P298_BinaryTreeLongestConsecutiveSequence {
  int len = 0;

  public int longestConsecutive(TreeNode root) {
    dfs(root);
    return len;
  }

  private int dfs(TreeNode root) {
    if (root == null) return 0;
    int left = dfs(root.left) + 1;
    int right = dfs(root.right) + 1;
    if (root.left != null && root.val + 1 != root.left.val) left = 1;
    if (root.right != null && root.val + 1 != root.right.val) right = 1;
    len = Math.max(len, Math.max(left, right));
    return len;
  }
}
