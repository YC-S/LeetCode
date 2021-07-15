package leetcode_tree;

import java.util.ArrayList;
import java.util.List;

public class P95_UniqueBinarySearchTreeII {
  public List<TreeNode> generateTrees(int n) {
    return generateTrees(1, n);
  }

  private List<TreeNode> generateTrees(int start, int end) {
    List<TreeNode> res = new ArrayList<>();
    if (start > end) {
      res.add(null);
      return res;
    }
    if (start == end) {
      res.add(new TreeNode(start));
      return res;
    }
    for (int i = start; i <= end; i++) {
      List<TreeNode> left = generateTrees(start, i - 1);
      List<TreeNode> right = generateTrees(i + 1, end);
      for (TreeNode lNode : left) {
        for (TreeNode rNode : right) {
          TreeNode root = new TreeNode(i);
          root.left = lNode;
          root.right = rNode;
          res.add(root);
        }
      }
    }
    return res;
  }
}
