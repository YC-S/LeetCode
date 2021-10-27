package leetcode500.P08_tree.plan7;

public class P513_FindBottomLeftTreeValue {
  public int findBottomLeftValue(TreeNode root) {
    return helper(root, 1, new int[] {0, 0});
  }

  private int helper(TreeNode root, int depth, int[] res) {
    if (res[1] < depth) {
      res[0] = root.val;
      res[1] = depth;
    }
    if (root.left != null) helper(root.left, depth + 1, res);
    if (root.right != null) helper(root.right, depth + 1, res);
    return res[0];
  }
}
