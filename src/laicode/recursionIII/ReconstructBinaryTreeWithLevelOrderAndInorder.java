package laicode.recursionIII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructBinaryTreeWithLevelOrderAndInorder {
  public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
    Map<Integer, Integer> inMap = new HashMap<>();
    for (int i = 0; i < inOrder.length; i++) {
      inMap.put(inOrder[i], i);
    }
    List<Integer> lList = new ArrayList<>();
    for (int num : levelOrder) {
      lList.add(num);
    }
    return helper(lList, inMap);
  }

  private TreeNode helper(List<Integer> level, Map<Integer, Integer> inMap) {
    if (level.isEmpty()) return null;
    TreeNode root = new TreeNode(level.remove(0));
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    for (int num : level) {
      if (inMap.get(num) < inMap.get(root.key)) left.add(num);
      else right.add(num);
    }
    root.left = helper(left, inMap);
    root.right = helper(right, inMap);
    return root;
  }
}
