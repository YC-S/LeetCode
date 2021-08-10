package leetcode500.P08_tree.plan1;

import java.util.ArrayList;
import java.util.List;

public class P94_BinaryTreeInorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(res, root);
    return res;
  }

  private void helper(List<Integer> res, TreeNode root) {
    if (root == null) return;
    helper(res, root.left);
    res.add(root.val);
    helper(res, root.right);
  }
}
