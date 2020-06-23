/*
 * Copyright (c) 2020. Yuanchen
 */

package june_challenge;

import utility.TreeNode;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/23
 */
public class P23CountCompleteTreeNodes {

  public int countNodes(TreeNode root) {
    return root != null ? 1 + countNodes(root.right) + countNodes(root.left)
      : 0;
  }
}
