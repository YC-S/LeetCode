package leetcode500.P08_tree.plan4;

public class P563_BinaryTreeTilt {
  public int findTilt(TreeNode root) {
    int[] res = new int[] {0};
    dfs(root, res);
    return res[0];
  }

  private int dfs(TreeNode root, int[] res) {
    if (root == null) return 0;
    int left = dfs(root.left, res);
    int right = dfs(root.right, res);
    res[0] += Math.abs(left - right);
    return left + right + root.val;
  }
}
