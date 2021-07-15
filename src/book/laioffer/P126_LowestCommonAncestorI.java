package book.laioffer;

public class P126_LowestCommonAncestorI {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
    if (root == null || one == root || two == root) return root;
    TreeNode left = lowestCommonAncestor(root.left, one, two);
    TreeNode right = lowestCommonAncestor(root.right, one, two);
    if (left != null && right != null) return root;
    return left == null ? right : left;
  }
}
