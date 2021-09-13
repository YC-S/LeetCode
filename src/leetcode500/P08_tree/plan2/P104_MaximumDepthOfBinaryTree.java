package leetcode500.P08_tree.plan2;

public class P104_MaximumDepthOfBinaryTree {
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return Math.max(left, right) + 1;
  }
}
