package leetcode500.P09_bst.plan1;

public class P285_InorderSuccessorInBST {
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    TreeNode successor = null;
    while (root != null) {
      if (p.val >= root.val) {
        root = root.right;
      } else {
        successor = root;
        root = root.left;
      }
    }
    return successor;
  }
}
