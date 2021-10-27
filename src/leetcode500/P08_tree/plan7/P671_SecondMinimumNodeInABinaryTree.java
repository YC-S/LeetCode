package leetcode500.P08_tree.plan7;

public class P671_SecondMinimumNodeInABinaryTree {
  public int findSecondMinimumValue(TreeNode root) {
    long[] res = new long[] {Long.MAX_VALUE};
    int[] min = new int[] {root.val};
    dfs(root, min, res);
    return res[0] == Long.MAX_VALUE ? -1 : (int) res[0];
  }

  private void dfs(TreeNode root, int[] min, long[] res) {
    if (root == null) return;
    if (min[0] < root.val && root.val < res[0]) {
      res[0] = root.val;
    } else if (min[0] == root.val) {
      dfs(root.left, min, res);
      dfs(root.right, min, res);
    }
  }
}
