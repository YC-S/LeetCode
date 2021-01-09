/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_june;

import java.util.Random;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/05
 */
public class P5RandomPickWithWeight {

  int[] sum;
  Random rand;
  int max;

  public P5RandomPickWithWeight(int[] w) {
    rand = new Random();
    sum = new int[w.length];
    sum[0] = w[0];
    for (int i = 1; i < w.length; i++) {
      sum[i] = sum[i - 1] + w[i];
    }
    max = sum[w.length - 1];
  }

  public int pickIndex() {
    int target =
      rand.nextInt(max) + 1;
    int start = 0;
    int end = sum.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (sum[mid] == target) {
        return mid;
      } else if (sum[mid] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return start;
  }
}
