package elite._0815;

public class FindLongest {
  public int findLongest(TreeNode root) {
    return dfs(root, Integer.MAX_VALUE, 0);
  }

  private int dfs(TreeNode cur, int prevLongest, int prevVal) {
    if (cur == null) return 0;
    int curLongest = cur.val > prevVal ? prevLongest + 1 : 1;
    int left = dfs(cur.left, cur.val, curLongest);
    int right = dfs(cur.right, cur.val, curLongest);
    return Math.max(Math.max(left, right), curLongest);
  }
}
