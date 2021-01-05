/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_may;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/05/19
 */
public class P19OnlineStockSpan {

  Deque<Integer> prices, weights;

  public P19OnlineStockSpan() {
    prices = new ArrayDeque<>();
    weights = new ArrayDeque<>();
  }

  public int next(int price) {
    int w = 1;
    while (!prices.isEmpty() && prices.peekFirst() <= price) {
      prices.pollFirst();
      w = w + weights.pollFirst();
    }

    prices.offerFirst(price);
    weights.offerFirst(w);
    return w;
  }

}
