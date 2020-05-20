/*
 * Copyright (c) 2020. Yuanchen
 */

package may_challenge;

import java.util.HashMap;
import java.util.Map;
import utility.TreeNode;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/05/20
 */
public class P20KthSmallestElementInBST {

  public int kthSmallest(TreeNode root, int k) {
    Map<TreeNode, Integer> numOfChildren = new HashMap<>();
    countNodes(root, numOfChildren);
    return quickSelectOnTree(root, k, numOfChildren);
  }

  private int countNodes(TreeNode root, Map<TreeNode, Integer> numOfChildren) {
    if (root == null) {
      return 0;
    }

    int left = countNodes(root.left, numOfChildren);
    int right = countNodes(root.right, numOfChildren);
    numOfChildren.put(root, left + right + 1);
    return left + right + 1;
  }

  private int quickSelectOnTree(TreeNode root, int k,
    Map<TreeNode, Integer> numOfChildren) {
    if (root == null) {
      return -1;
    }

    int left = root.left == null ? 0 : numOfChildren.get(root.left);
    if (left >= k) {
      return quickSelectOnTree(root.left, k, numOfChildren);
    }
    if (left + 1 == k) {
      return root.val;
    }

    return quickSelectOnTree(root.right, k - left - 1, numOfChildren);
  }
}
