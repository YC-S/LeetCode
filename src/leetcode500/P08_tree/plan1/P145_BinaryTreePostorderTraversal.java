package leetcode500.P08_tree.plan1;

import java.util.ArrayList;
import java.util.List;

public class P145_BinaryTreePostorderTraversal {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
  }

  private void helper(TreeNode root, List<Integer> res) {
    if (root == null) return;
    helper(root.left, res);
    helper(root.right, res);
    res.add(root.val);
  }
}
