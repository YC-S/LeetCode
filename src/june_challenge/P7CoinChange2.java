/*
 * Copyright (c) 2020. Yuanchen
 */

package june_challenge;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/07
 */
public class P7CoinChange2 {

  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int coin : coins) {
      for (int x = coin; x < amount + 1; ++x) {
        dp[x] += dp[x - coin];
      }
    }
    return dp[amount];
  }
}
