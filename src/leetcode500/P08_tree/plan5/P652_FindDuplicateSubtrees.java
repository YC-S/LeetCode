package leetcode500.P08_tree.plan5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P652_FindDuplicateSubtrees {
  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    Map<String, List<TreeNode>> map = new HashMap<>();
    List<TreeNode> dups = new ArrayList<>();
    serialize(root, map);
    for (List<TreeNode> group : map.values()) if (group.size() > 1) dups.add(group.get(0));
    return dups;
  }

  private String serialize(TreeNode node, Map<String, List<TreeNode>> map) {
    if (node == null) return "";
    String s = "(" + serialize(node.left, map) + node.val + serialize(node.right, map) + ")";
    map.putIfAbsent(s, new ArrayList<>());
    map.get(s).add(node);
    return s;
  }
}
