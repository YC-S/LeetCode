package leetcode500.P09_bst.plan2;

public class P783_MinimumDistanceBetweenBSTNodes {
  Integer prev, ans;

  public int minDiffInBST(TreeNode root) {
    prev = null;
    ans = Integer.MAX_VALUE;
    dfs(root);
    return ans;
  }

  private void dfs(TreeNode node) {
    if (node == null) return;
    dfs(node.left);
    if (prev != null) {
      ans = Math.min(ans, node.val - prev);
    }
    prev = node.val;
    dfs(node.right);
  }
}
