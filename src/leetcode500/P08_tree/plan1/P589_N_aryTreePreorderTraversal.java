package leetcode500.P08_tree.plan1;

import java.util.ArrayList;
import java.util.List;

public class P589_N_aryTreePreorderTraversal {
  public List<Integer> preorder(Node root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
  }

  private void helper(Node root, List<Integer> res) {
    if (root == null) return;
    res.add(root.val);
    for (Node node : root.children) {
      helper(node, res);
    }
  }
}
