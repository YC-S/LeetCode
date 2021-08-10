package leetcode500.P08_tree.plan1;

import java.util.ArrayList;
import java.util.List;

public class P144_BinaryTreePreorderTraversal {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
  }

  private void helper(TreeNode root, List<Integer> list) {
    if (root == null) return;
    list.add(root.val);
    helper(root.left, list);
    helper(root.right, list);
  }
}
