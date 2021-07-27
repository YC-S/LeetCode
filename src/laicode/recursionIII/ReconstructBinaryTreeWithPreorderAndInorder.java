package laicode.recursionIII;

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTreeWithPreorderAndInorder {
  public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
    Map<Integer, Integer> inIndex = indexMap(inOrder);
    return helper(preOrder, inIndex, 0, inOrder.length - 1, 0, preOrder.length - 1);
  }

  private Map<Integer, Integer> indexMap(int[] inOrder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inOrder.length; i++) {
      map.put(inOrder[i], i);
    }
    return map;
  }

  private TreeNode helper(
      int[] pre,
      Map<Integer, Integer> inIndex,
      int inLeft,
      int inRight,
      int preLeft,
      int preRight) {
    if (inLeft > inRight) return null;
    TreeNode root = new TreeNode(pre[preLeft]);
    int inMid = inIndex.get(root.key);
    root.left = helper(pre, inIndex, inLeft, inMid - 1, preLeft + 1, preLeft + inMid - inLeft);
    root.right = helper(pre, inIndex, inMid + 1, inRight, preRight + inMid - inRight + 1, preRight);
    return root;
  }
}
