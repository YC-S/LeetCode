package leetcode500.P08_tree.plan3;

import java.util.ArrayList;
import java.util.List;

public class P113_HasPathSumII {
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    dfs(root, targetSum, cur, res);
    return res;
  }

  private void dfs(TreeNode root, int targetSum, List<Integer> cur, List<List<Integer>> res) {
    if (root == null) return;
    cur.add(root.val);
    if (root.left == null && root.right == null && targetSum == root.val) {
      res.add(new ArrayList<>(cur));
      cur.remove(cur.size() - 1);
      return;
    } else {
      dfs(root.left, targetSum - root.val, cur, res);
      dfs(root.right, targetSum - root.val, cur, res);
    }
    cur.remove(cur.size() - 1);
  }
}
