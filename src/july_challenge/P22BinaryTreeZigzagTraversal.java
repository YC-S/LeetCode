/*
 * Copyright (c) 2020. Yuanchen
 */

package july_challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import utility.TreeNode;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/22
 */
public class P22BinaryTreeZigzagTraversal {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    helper(root, res, 0);
    return res;
  }

  private void helper(TreeNode root, List<List<Integer>> res, int level) {
    if (root == null) {
      return;
    }
    if (res.size() <= level) {
      List<Integer> newLevel = new LinkedList<>();
      res.add(newLevel);
    }

    List<Integer> collection = res.get(level);
    if (level % 2 == 0) {
      collection.add(root.val);
    } else {
      collection.add(0, root.val);
    }

    helper(root.left, res, level + 1);
    helper(root.right, res, level + 1);
  }
}
