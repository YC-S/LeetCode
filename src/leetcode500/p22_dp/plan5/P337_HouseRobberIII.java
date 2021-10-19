package leetcode500.p22_dp.plan5;

public class P337_HouseRobberIII {
  public int rob(TreeNode root) {
    int[] ans = dp(root);
    return Math.max(ans[0], ans[1]);
  }

  private int[] dp(TreeNode root) {
    if (root == null) {
      return new int[] {0, 0};
    }
    int[] left = dp(root.left);
    int[] right = dp(root.right);
    int[] now = new int[2];
    now[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    now[1] = left[0] + right[0] + root.val;
    return now;
  }
}
