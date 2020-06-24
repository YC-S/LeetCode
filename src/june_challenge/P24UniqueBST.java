/*
 * Copyright (c) 2020. Yuanchen
 */

package june_challenge;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/24
 */
public class P24UniqueBST {

  public int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int level = 2; level <= n; level++) {
      for (int root = 1; root <= level; root++) {
        dp[level] += dp[level - root] * dp[root - 1];
      }
    }
    return dp[n];
  }
}
