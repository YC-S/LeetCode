package leetcode500.P08_tree.plan5;

import java.util.ArrayList;
import java.util.List;

public class P366_FindLeavesOfBinaryTrees {
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    height(root, res);
    return res;
  }

  private int height(TreeNode root, List<List<Integer>> res) {
    if (root == null) return -1;
    int level = 1 + Math.max(height(root.left, res), height(root.right, res));
    if (res.size() == level) res.add(new ArrayList<>());
    res.get(level).add(root.val);
    return level;
  }
}
