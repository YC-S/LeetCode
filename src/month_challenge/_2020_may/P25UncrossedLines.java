/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_may;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/05/25
 */
public class P25UncrossedLines {

  public int maxUncrossedLines(int[] A, int[] B) {
    int[][] dp = new int[2][B.length + 1];

    int flag = 1;
    for (int i = A.length - 1; i >= 0; i--) {
      for (int j = B.length - 1; j >= 0; j--) {
        dp[flag][j] = (A[i] == B[j]
          ? dp[flag ^ 1][j + 1] + 1
          : Math.max(dp[flag][j + 1], dp[flag ^ 1][j]));
      }
      flag ^= 1;
    }

    return dp[flag ^ 1][0];
  }

}
