/*
 * Copyright (c) 2020. Yuanchen
 */

package june_challenge;

import utility.TreeNode;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/15
 */
public class P15SearchInBST {

  public TreeNode searchBST(TreeNode root, int val) {
    while (root != null && val != root.val) {
      root = val < root.val ? root.left : root.right;
    }
    return root;
  }
}
