package leetcode500.P08_tree.plan3;

public class P129_SumRootToLeafNumbers {
  public int sumNumbers(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    int[] res = new int[] {0};
    dfs(root, sb, res);
    return res[0];
  }

  private void dfs(TreeNode root, StringBuilder sb, int[] res) {
    if (root == null) return;
    int len = sb.length();
    sb.append(root.val);
    if (root.left == null && root.right == null) {
      res[0] += Integer.parseInt(sb.toString());
    } else {
      dfs(root.left, sb, res);
      dfs(root.right, sb, res);
    }
    sb.setLength(len);
  }
}
