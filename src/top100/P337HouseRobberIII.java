/*
 * Copyright (c) 2020. Yuanchen
 */

package top100;

import utility.TreeNode;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/08
 */
public class P337HouseRobberIII {

  public int rob(TreeNode root) {
    int[] ans = dp(root);
    return Math.max(ans[0], ans[1]);
  }

  public int[] dp(TreeNode root) {
    if (root == null) {
      int[] now = new int[]{0, 0};
      return now;
    }
    int[] left = dp(root.left);
    int[] right = dp(root.right);
    int[] now = new int[2];
    now[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    now[1] = left[0] + right[0] + root.val;
    return now;
  }
}
