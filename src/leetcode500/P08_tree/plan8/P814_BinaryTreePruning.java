package leetcode500.P08_tree.plan8;

public class P814_BinaryTreePruning {
  public TreeNode pruneTree(TreeNode root) {
    if (root == null) return root;
    root.left = pruneTree(root.left);
    root.right = pruneTree(root.right);
    if (root.left == null && root.right == null && root.val == 0) return null;
    return root;
  }
}
