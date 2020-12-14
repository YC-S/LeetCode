/*
 * Copyright (c) 2020. Yuanchen
 */

package contest._219;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/12
 */
public class StoneGameVII {


    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] preSum = new int[n];
        preSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            preSum[i] += preSum[i - 1] + stones[i];
        }
        int[][] dp = new int[n][n];
        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                dp[i][j] = preSum[j - 1] - (i == 0 ? 0 : preSum[i - 1]) - dp[i][j - 1];
                if (dp[i][j] < preSum[j] - preSum[i] - dp[i + 1][j]) {
                    dp[i][j] = preSum[j] - preSum[i] - dp[i + 1][j];
                }
            }
        }
        return dp[0][n - 1];
    }

}
