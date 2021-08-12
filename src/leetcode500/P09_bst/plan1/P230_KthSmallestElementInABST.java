package leetcode500.P09_bst.plan1;

public class P230_KthSmallestElementInABST {

  public int kthSmallest(TreeNode root, int k) {
    int count = countNodes(root);
    if (k <= count) return kthSmallest(root.left, k);
    else if (k > count + 1) return kthSmallest(root.right, k - count - 1);
    return root.val;
  }

  private int countNodes(TreeNode root) {
    if (root == null) return 0;
    return countNodes(root.left) + countNodes(root.right) + 1;
  }
}
