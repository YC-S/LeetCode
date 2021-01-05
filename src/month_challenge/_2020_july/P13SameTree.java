/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_july;

import utility.TreeNode;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/13
 */
public class P13SameTree {

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right,
      q.right);
  }
}
