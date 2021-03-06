/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.top100;

import utility.TreeNode;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/08
 */
public class P437PathSumIII {

  public int pathSum(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }

    return pathSum(root.left, sum) + pathSum(root.right, sum) + findPath(root,
      sum);
  }


  public int findPath(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }
    int res = 0;
    if (sum == root.val) {
      res += 1;
    }

    res += findPath(root.left, sum - root.val);
    res += findPath(root.right, sum - root.val);
    return res;
  }
}
