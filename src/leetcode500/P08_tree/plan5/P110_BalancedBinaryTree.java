package leetcode500.P08_tree.plan5;

public class P110_BalancedBinaryTree {
  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    boolean leftB = isBalanced(root.left);
    boolean rightB = isBalanced(root.right);
    if (!leftB || !rightB) return false;
    int left = getHeight(root.left);
    int right = getHeight(root.right);
    return Math.abs(left - right) <= 1;
  }

  private int getHeight(TreeNode root) {
    if (root == null) return 0;
    int left = getHeight(root.left);
    int right = getHeight(root.right);
    return Math.max(left, right) + 1;
  }
}
