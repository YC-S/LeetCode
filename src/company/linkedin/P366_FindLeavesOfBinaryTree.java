package company.linkedin;

import java.util.ArrayList;
import java.util.List;

public class P366_FindLeavesOfBinaryTree {
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> leavesList = new ArrayList<>();
    List<Integer> leaves = new ArrayList<>();
    while (root != null) {
      if (isLeave(root, leaves)) root = null;
      leavesList.add(leaves);
      leaves = new ArrayList<>();
    }
    return leavesList;
  }

  public boolean isLeave(TreeNode node, List<Integer> leaves) {
    if (node.left == null && node.right == null) {
      leaves.add(node.val);
      return true;
    }
    if (node.left != null) {
      if (isLeave(node.left, leaves)) node.left = null;
    }
    if (node.right != null) {
      if (isLeave(node.right, leaves)) node.right = null;
    }
    return false;
  }
}
