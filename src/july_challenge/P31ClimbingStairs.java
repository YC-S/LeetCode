/*
 * Copyright (c) 2020. Yuanchen
 */

package july_challenge;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/31
 */
public class P31ClimbingStairs {

  public static void main(String[] args) {
    P31ClimbingStairs solution = new P31ClimbingStairs();
    System.out.println(solution.climbStairs(3));
    System.out.println(solution.climbStairs(2));
    System.out.println(solution.climbStairs(4));
  }

  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }
}
