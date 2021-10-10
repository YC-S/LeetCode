package leetcode500.P08_tree.plan4;

public class P663_EqualTreePartition {
  int treeSum = 0;

  public boolean checkEqualTree(TreeNode root) {
    this.treeSum = getSum(root);
    return equalTree(root)[1] == 1;
  }

  private int[] equalTree(TreeNode root) {
    if (root == null) return new int[] {0, 0};
    int[] leftTree = equalTree(root.left);
    int[] rightTree = equalTree(root.right);
    int currTreeSum = leftTree[0] + rightTree[0] + root.val;
    if (leftTree[1] == 1 || rightTree[1] == 1) return new int[] {currTreeSum, 1};
    if ((root.left != null && this.treeSum == 2 * leftTree[0])
        || (root.right != null && this.treeSum == 2 * rightTree[0])) {
      return new int[] {currTreeSum, 1};
    }
    return new int[] {currTreeSum, 0};
  }

  private int getSum(TreeNode root) {
    if (root == null) return 0;
    return root.val + getSum(root.left) + getSum(root.right);
  }
}
