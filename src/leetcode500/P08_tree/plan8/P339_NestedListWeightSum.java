package leetcode500.P08_tree.plan8;

import java.util.List;

public class P339_NestedListWeightSum {
  public int depthSum(List<NestedInteger> nestedList) {
    return dfs(nestedList, 1);
  }

  private int dfs(List<NestedInteger> list, int depth) {
    int sum = 0;
    for (NestedInteger n : list) {
      if (n.isInteger()) {
        sum += n.getInteger() * depth;
      } else {
        sum += dfs(n.getList(), depth + 1);
      }
    }
    return sum;
  }
}
