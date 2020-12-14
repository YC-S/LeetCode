/*
 * Copyright (c) 2020. Yuanchen
 */

package contest._219;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/12
 */
public class MaximumHeightByStackingCuboids {

    public int maxHeight(int[][] cuboids) {
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        int n = cuboids.length;
        Arrays.sort(cuboids, (a, b) -> (a[0] == b[0] ? (a[1] == b[1] ? (a[2] - b[2]) : a[1] - b[1]) : a[0] - b[0]));
        int[] dp = new int[n];
        dp[0] = cuboids[0][2];
        int max = dp[0];
        for (int i = 1; i < cuboids.length; i++) {
            dp[i] = cuboids[i][2];
            for (int j = i - 1; j >= 0; j--) {
                if (helper(cuboids[j], cuboids[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public boolean helper(int[] cuboid1, int[] cuboid2) {
        for (int i = 0; i < 3; i++) {
            if (cuboid1[i] > cuboid2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean satisfy(int[] o1, int[] o2) {
        return o1[0] <= o2[0] && o1[1] <= o2[1] && o1[2] <= o2[2];
    }
}
