package leetcode500.P09_bst.plan1;

public class P270_ClosestBinarySearchTreeValue {
  public int closestValue(TreeNode root, double target) {
    int cur, closest = root.val;
    while (root != null) {
      cur = root.val;
      closest = Math.abs(closest - target) < Math.abs(cur - target) ? closest : cur;
      root = target < root.val ? root.left : root.right;
    }
    return closest;
  }
}
