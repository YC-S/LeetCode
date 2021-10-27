package leetcode500.P08_tree.plan8;

import java.util.List;

public class P364_NestedListWeightSumII {
  public int depthSumInverse(List<NestedInteger> nestedList) {
    int maxDepth = Integer.MIN_VALUE;

    for (NestedInteger num : nestedList) {
      maxDepth = Math.max(maxDepth, getDepth(num, 1));
    }

    int sum = 0;
    for (NestedInteger num : nestedList) {
      sum += getSum(num, 0, maxDepth);
    }

    return sum;
  }

  private int getSum(NestedInteger num, int depth, int maxDepth) {
    if (num.isInteger()) {
      return num.getInteger() * (maxDepth - depth);
    }
    int sum = 0;
    for (NestedInteger next : num.getList()) {
      sum += getSum(next, depth + 1, maxDepth);
    }

    return sum;
  }

  private int getDepth(NestedInteger num, int depth) {
    if (num.isInteger()) {
      return depth;
    }
    int max = depth;
    for (NestedInteger next : num.getList()) {
      max = Math.max(max, getDepth(next, depth + 1));
    }

    return max;
  }
}
