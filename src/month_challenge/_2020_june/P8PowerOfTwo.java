/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_june;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/08
 */
public class P8PowerOfTwo {

  public boolean isPowerOfTwo(int n) {
    if (n <= 0) {
      return false;
    }
    while ((n & 1) == 0) {
      n >>= 1;
    }
    return n == 1;
  }
}
