package leetcode500.P09_bst.plan1;

import java.util.ArrayList;
import java.util.List;

public class P173_BinarySearchTreeIterator {
  private final List<Integer> list = new ArrayList<>();
  private final TreeNode root;
  private int index = 0;

  public P173_BinarySearchTreeIterator(TreeNode root) {
    this.root = root;
    inOrder(root, list);
  }

  private void inOrder(TreeNode root, List<Integer> list) {
    if (root == null) return;
    inOrder(root.left, list);
    list.add(root.val);
    inOrder(root.right, list);
  }

  public int next() {
    return list.get(index++);
  }

  public boolean hasNext() {
    return index < list.size();
  }
}
