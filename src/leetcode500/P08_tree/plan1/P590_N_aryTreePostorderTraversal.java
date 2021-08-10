package leetcode500.P08_tree.plan1;

import java.util.ArrayList;
import java.util.List;

public class P590_N_aryTreePostorderTraversal {
  public List<Integer> postorder(Node root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
  }

  private void helper(Node root, List<Integer> res) {
    if (root == null) return;
    for (Node node : root.children) {
      helper(node, res);
    }
    res.add(root.val);
  }
}
