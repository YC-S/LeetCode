package leetcode500.P08_tree.plan8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P1110_DeleteNodesAndReturnForest {
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    Set<Integer> set = new HashSet<>();
    for (int x : to_delete) set.add(x);
    List<TreeNode> list = new ArrayList<>();
    delete(root, set, false, list);
    return list;
  }

  private TreeNode delete(TreeNode x, Set<Integer> set, boolean connected, List<TreeNode> list) {
    if (x == null) return null;
    if (set.contains(x.val)) {
      delete(x.left, set, false, list);
      delete(x.right, set, false, list);
      x = null;
    } else {
      if (!connected) list.add(x);
      x.left = delete(x.left, set, true, list);
      x.right = delete(x.right, set, true, list);
    }
    return x;
  }
}
