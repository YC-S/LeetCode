package leetcode500.P08_tree.plan3;

public class P437_PathSumIII {
  public int pathSum(TreeNode root, int targetSum) {
    if (root == null) return 0;
    return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + dfs(root, targetSum);
  }

  private int dfs(TreeNode root, int targetSum) {
    if (root == null) return 0;
    int res = 0;
    if (targetSum == root.val) res++;
    res += dfs(root.left, targetSum - root.val);
    res += dfs(root.right, targetSum - root.val);
    return res;
  }
}
