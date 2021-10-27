package leetcode500.P08_tree.plan7;

import java.util.ArrayList;
import java.util.List;

public class P199_BinaryTreeRightSideView {
  List<Integer> res = new ArrayList<>();

  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) return res;
    helper(root, 0);
    return res;
  }

  private void helper(TreeNode root, int level) {
    if (root == null) return;
    if (level == res.size()) res.add(root.val);
    if (root.right != null) helper(root.right, level + 1);
    if (root.left != null) helper(root.left, level + 1);
  }
}
