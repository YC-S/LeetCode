/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_july;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/29
 */
public class P29MaxProfit {

  public int maxProfit(int[] prices) {

    int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;

    for (int price : prices) {
      int preSold = sold;

      sold = held + price;
      held = Math.max(held, reset - price);
      reset = Math.max(reset, preSold);
    }

    return Math.max(sold, reset);
  }
}
