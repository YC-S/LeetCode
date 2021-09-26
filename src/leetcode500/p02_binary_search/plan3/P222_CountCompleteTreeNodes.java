package leetcode500.p02_binary_search.plan3;

public class P222_CountCompleteTreeNodes {
  public int countNodes(TreeNode root) {
    return root != null ? 1 + countNodes(root.right) + countNodes(root.left) : 0;
  }
}
