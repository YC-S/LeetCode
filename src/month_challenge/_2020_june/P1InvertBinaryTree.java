/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_june;

import utility.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/01
 */
public class P1InvertBinaryTree {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    final Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      final TreeNode node = queue.poll();
      final TreeNode left = node.left;
      node.left = node.right;
      node.right = left;

      if (node.left != null) {
        queue.offer(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
      }
    }
    return root;
  }

}
