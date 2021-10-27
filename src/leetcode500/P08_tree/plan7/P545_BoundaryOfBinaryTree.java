package leetcode500.P08_tree.plan7;

import java.util.ArrayList;
import java.util.List;

public class P545_BoundaryOfBinaryTree {
  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    res.add(root.val);
    leftBoundary(root.left, res);
    leaves(root.left, res);
    leaves(root.right, res);
    rightBoundary(root.right, res);
    return res;
  }

  public void leftBoundary(TreeNode root, List<Integer> result) {
    if (root == null || (root.left == null && root.right == null)) return;
    result.add(root.val);
    if (root.left == null) leftBoundary(root.right, result);
    else leftBoundary(root.left, result);
  }

  public void rightBoundary(TreeNode root, List<Integer> result) {
    if (root == null || (root.right == null && root.left == null)) return;
    if (root.right == null) rightBoundary(root.left, result);
    else rightBoundary(root.right, result);
    result.add(root.val); // add after child visit(reverse)
  }

  public void leaves(TreeNode root, List<Integer> result) {
    if (root == null) return;
    if (root.left == null && root.right == null) {
      result.add(root.val);
      return;
    }
    leaves(root.left, result);
    leaves(root.right, result);
  }
}
