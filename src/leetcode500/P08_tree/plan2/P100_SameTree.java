package leetcode500.P08_tree.plan2;

public class P100_SameTree {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
  }
}
