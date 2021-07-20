package laicode.cross_trainingI;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LowestCommonAncestorIV {
  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    Set<TreeNode> set = new HashSet<>(nodes);
    return helper(root, set);
  }

  private TreeNode helper(TreeNode root, Set<TreeNode> set) {
    if (root == null || set.contains(root)) return root;
    TreeNode l = helper(root.left, set);
    TreeNode r = helper(root.right, set);
    if (l != null && r != null) return root;
    return l == null ? r : l;
  }
}
