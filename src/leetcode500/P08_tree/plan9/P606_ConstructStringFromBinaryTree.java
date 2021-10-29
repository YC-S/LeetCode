package leetcode500.P08_tree.plan9;

public class P606_ConstructStringFromBinaryTree {
  public String tree2str(TreeNode root) {
    if (root == null) return "";
    StringBuilder sb = new StringBuilder();
    helper(root, sb);
    return sb.toString();
  }

  private void helper(TreeNode root, StringBuilder sb) {
    sb.append(root.val);
    if (root.left == null && root.right == null) return;
    if (root.left != null) {
      sb.append("(");
      helper(root.left, sb);
      sb.append(")");
    }
    if (root.right != null) {
      if (root.left == null) {
        sb.append("()");
      }
      sb.append("(");
      helper(root.right, sb);
      sb.append(")");
    }
  }
}
