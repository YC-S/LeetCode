package leetcode500.P08_tree.plan4;

public class P250_CountUnivalueSubtrees {
  public int countUnivalSubtrees(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return 1;
    int res = countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
    return helper(root) ? res + 1 : res;
  }

  private boolean helper(TreeNode root) {
    if (root == null) return true;
    if (root.left == null && root.right == null) {
      return true;
    }
    if (helper(root.left) && helper(root.right)) {
      if (root.left != null && root.right != null) {
        return root.val == root.left.val && root.left.val == root.right.val;
      }
      if (root.left != null) {
        return root.left.val == root.val;
      }
      if (root.right != null) {
        return root.right.val == root.val;
      }
    }
    return false;
  }
}
