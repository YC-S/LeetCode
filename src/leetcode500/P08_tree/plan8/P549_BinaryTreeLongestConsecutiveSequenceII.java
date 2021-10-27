package leetcode500.P08_tree.plan8;

public class P549_BinaryTreeLongestConsecutiveSequenceII {
  int maxLen = 0;

  public int longestConsecutive(TreeNode root) {
    dfs(root);
    return maxLen;
  }

  private int[] dfs(TreeNode root) {
    if (root == null) return new int[] {0, 0};
    int inc = 1, dec = 1;
    if (root.left != null) {
      int[] left = dfs(root.left);
      if (root.val == root.left.val + 1) {
        dec = left[1] + 1;
      } else if (root.val == root.left.val - 1) {
        inc = left[0] + 1;
      }
    }
    if (root.right != null) {
      int[] right = dfs(root.right);
      if (root.val == root.right.val + 1) {
        dec = Math.max(dec, right[1] + 1);
      } else if (root.val == root.right.val - 1) {
        inc = Math.max(inc, right[0] + 1);
      }
    }
    maxLen = Math.max(dec + inc - 1, maxLen);
    return new int[] {inc, dec};
  }
}
