package leetcode500.p22_dp.plan8;

public class P1000_MinimumCostToMergeStones {
  public int mergeStones(int[] stones, int k) {
    int len = stones.length;
    if ((len - 1) % (k - 1) != 0) {
      return -1;
    }

    int i, j, p, l, t;

    int[] prefixSum = new int[len + 1];
    for (i = 1; i <= len; i++) {
      prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
    }

    int max = 9999999;
    int[][][] dp = new int[len + 1][len + 1][k + 1];
    for (i = 1; i <= len; i++) {
      for (j = 1; j <= len; j++) {
        for (p = 1; p <= k; p++) {
          dp[i][j][p] = max;
        }
      }
    }

    for (i = 1; i <= len; i++) {
      dp[i][i][1] = 0;
    }

    for (l = 2; l <= len; l++) {
      for (i = 1; i <= len - l + 1; i++) {
        j = i + l - 1;
        for (p = 2; p <= k; p++) {
          for (t = i; t < j; t++) {
            dp[i][j][p] = Math.min(dp[i][j][p], dp[i][t][p - 1] + dp[t + 1][j][1]);
          }
        }

        dp[i][j][1] = dp[i][j][k] + prefixSum[j] - prefixSum[i - 1];
      }
    }

    return dp[1][len][1];
  }
}
