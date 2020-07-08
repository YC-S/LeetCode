/*
 * Copyright (c) 2020. Yuanchen
 */

package top100;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/08
 */
public class P739DailyTemperatures {

  public int[] dailyTemperatures(int[] T) {
    int[] ans = new int[T.length];
    int[] next = new int[101];
    Arrays.fill(next, Integer.MAX_VALUE);
    for (int i = T.length - 1; i >= 0; --i) {
      int warmer_index = Integer.MAX_VALUE;
      for (int t = T[i] + 1; t <= 100; ++t) {
        if (next[t] < warmer_index) {
          warmer_index = next[t];
        }
      }
      if (warmer_index < Integer.MAX_VALUE) {
        ans[i] = warmer_index - i;
      }
      next[T[i]] = i;
    }
    return ans;
  }
}
