package leetcode500.P09_bst.plan2;

public class P538_ConvertBSTToGreaterTree {
  int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    convert(root);
    return root;
  }

  private void convert(TreeNode cur) {
    if (cur == null) return;
    convert(cur.right);
    cur.val += sum;
    sum = cur.val;
    convert(cur.left);
  }
}
