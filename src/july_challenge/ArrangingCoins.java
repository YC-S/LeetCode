/*
 * Copyright (c) 2020. Yuanchen
 */

package july_challenge;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/01
 */
public class ArrangingCoins {

  public int arrangeCoins(int n) {
    return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
  }
}
