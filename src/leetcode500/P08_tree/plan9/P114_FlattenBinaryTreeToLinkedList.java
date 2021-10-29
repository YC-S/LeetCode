package leetcode500.P08_tree.plan9;

public class P114_FlattenBinaryTreeToLinkedList {
  private TreeNode prev = null;

  public void flatten(TreeNode root) {
    if (root == null) return;
    flatten(root.left);
    flatten(root.right);
    root.right = prev;
    root.left = null;
    prev = root;
  }
}
