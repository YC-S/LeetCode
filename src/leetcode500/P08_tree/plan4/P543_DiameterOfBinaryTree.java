package leetcode500.P08_tree.plan4;

public class P543_DiameterOfBinaryTree {
  public int diameterOfBinaryTree(TreeNode root) {
    int[] res = {0};
    dfs(root, res);
    return res[0] - 1;
  }

  private int dfs(TreeNode root, int[] res) {
    if (root == null) return 0;
    int left = dfs(root.left, res);
    int right = dfs(root.right, res);
    res[0] = Math.max(res[0], left + right + 1);
    return Math.max(left, right) + 1;
  }
}
