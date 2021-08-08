package leetcode500.p04_linked_list.plan1_reverse;

public class P156_BinaryTreeUpsideDown {
  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root == null) return null;
    else if (root.left == null) return root;

    TreeNode newRoot = upsideDownBinaryTree(root.left);
    TreeNode left = root.left;
    TreeNode right = root.right;
    root.left = null;
    root.right = null;
    left.left = right;
    left.right = root;
    return newRoot;
  }
}
