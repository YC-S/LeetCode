package leetcode500.P09_bst.plan1;

import java.util.ArrayList;
import java.util.List;

public class P501_FindModeInBinarySearchTree {
  private TreeNode prev;
  private int count;
  private int maxCount;

  public int[] findMode(TreeNode root) {
    if (root == null) return new int[0];
    prev = root;
    List<Integer> list = new ArrayList<>();
    inOrder(root, list);
    int[] res = new int[list.size()];
    for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
    return res;
  }

  private void inOrder(TreeNode root, List<Integer> list) {
    if (root == null) return;
    inOrder(root.left, list);
    count = prev.val == root.val ? count + 1 : 1;
    if (count == maxCount) {
      list.add(root.val);
    } else if (count > maxCount) {
      maxCount = count;
      list.clear();
      list.add(root.val);
    }
    prev = root;
    inOrder(root.right, list);
  }
}
