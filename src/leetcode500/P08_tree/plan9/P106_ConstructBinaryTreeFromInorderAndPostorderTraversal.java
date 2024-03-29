package leetcode500.P08_tree.plan9;

public class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return buildTree(inorder, inorder.length - 1, 0, postorder, postorder.length - 1);
  }

  private TreeNode buildTree(
      int[] inorder, int inStart, int inEnd, int[] postorder, int postStart) {
    if (postStart < 0 || inStart < inEnd) return null;
    TreeNode root = new TreeNode(postorder[postStart]);
    int rIndex = inStart;
    for (int i = inStart; i >= inEnd; i--) {
      if (inorder[i] == postorder[postStart]) {
        rIndex = i;
        break;
      }
    }
    root.right = buildTree(inorder, inStart, rIndex + 1, postorder, postStart - 1);
    root.left =
        buildTree(inorder, rIndex - 1, inEnd, postorder, postStart - (inStart - rIndex) - 1);
    return root;
  }
}
