/*
 * Copyright (c) 2020. Yuanchen
 */

package contest.leetcode.单周赛._217;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/28
 */
public class MinimumMovesToMakeArrayComplementary {

    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{28, 50, 76, 80, 64, 30, 32, 84, 53, 8
        }, 84));
    }

    public static int minMoves(int[] nums, int limit) {
        int[] delta = new int[2 * limit + 2];
        Arrays.fill(delta, 0);
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i], b = nums[n - 1 - i];
            delta[2] += 2;
            delta[Math.min(a, b) + 1]--;
            delta[a + b]--;
            delta[a + b + 1]++;
            delta[Math.max(a, b) + limit + 1]++;
        }
        int res = 2 * n, curr = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            curr += delta[i];
            res = Math.min(res, curr);
        }
        return res;
    }

}
