package leetcode500.P08_tree.plan9;

import java.util.HashMap;
import java.util.Map;

public class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inIndex = indexMap(inorder);
    return helper(preorder, inIndex, 0, inorder.length - 1, 0, preorder.length - 1);
  }

  private Map<Integer, Integer> indexMap(int[] inorder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return map;
  }

  private TreeNode helper(
      int[] preorder,
      Map<Integer, Integer> inIndex,
      int inLeft,
      int inRight,
      int preLeft,
      int preRight) {
    if (inLeft > inRight) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[preLeft]);
    int inMid = inIndex.get(root.val);
    root.left = helper(preorder, inIndex, inLeft, inMid - 1, preLeft + 1, preLeft + inMid - inLeft);
    root.right =
        helper(preorder, inIndex, inMid + 1, inRight, preRight + inMid - inRight + 1, preRight);
    return root;
  }
}
