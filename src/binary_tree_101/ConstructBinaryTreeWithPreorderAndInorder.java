/*
 * Copyright (c) 2020. Yuanchen
 */

package binary_tree_101;

import java.util.HashMap;
import java.util.Map;
import utility.TreeNode;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/31
 */
public class ConstructBinaryTreeWithPreorderAndInorder {

  public static TreeNode reconstruct(int[] inorder, int[] preorder) {
    Map<Integer, Integer> inIndex = indexMap(inorder);
    return helper(preorder, inIndex, 0, inorder.length - 1, 0,
      preorder.length - 1);
  }

  private static Map<Integer, Integer> indexMap(int[] inorder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return map;
  }

  private static TreeNode helper(int[] preorder, Map<Integer, Integer> inIndex,
    int inLeft, int inRight, int preLeft, int preRight) {
    if (inLeft > inRight) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[preLeft]);
    int inMid = inIndex.get(root.val);
    root.left = helper(preorder, inIndex, inLeft, inMid - 1, preLeft + 1,
      preLeft + inMid - inLeft);
    root.right = helper(preorder, inIndex, inMid + 1, inRight,
      preRight + inMid - inRight + 1, preRight);
    return root;
  }

  public static void main(String[] args) {
    int[] preorder = {3, 9, 20, 15, 7};
    int[] inorder = {9, 3, 15, 20, 7};
    TreeNode result = reconstruct(inorder, preorder);
  }
}
