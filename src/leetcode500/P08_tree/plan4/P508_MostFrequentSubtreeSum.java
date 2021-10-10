package leetcode500.P08_tree.plan4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P508_MostFrequentSubtreeSum {
  public int[] findFrequentTreeSum(TreeNode root) {
    Map<Integer, Integer> map = new HashMap<>();
    int[] maxCount = {0};

    dfs(root, map, maxCount);
    List<Integer> list = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == maxCount[0]) {
        list.add(entry.getKey());
      }
    }
    int n = list.size();
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      res[i] = list.get(i);
    }
    return res;
  }

  private int dfs(TreeNode root, Map<Integer, Integer> map, int[] maxCount) {
    if (root == null) return 0;
    int left = dfs(root.left, map, maxCount);
    int right = dfs(root.right, map, maxCount);
    int cur = left + right + root.val;
    map.put(cur, map.getOrDefault(cur, 0) + 1);
    maxCount[0] = Math.max(maxCount[0], map.get(cur));
    return left + right + root.val;
  }
}
