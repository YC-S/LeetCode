/*
 * Copyright (c) 2020. Yuanchen
 */

package july_challenge;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/17
 */
public class P16Pow {

  public double myPow(double x, int n) {
    Long N = n;
    if (N == 0) {
      return 1;
    }
    if (N > 0) {
      double half = myPow(x, (int) N / 2);
      return N % 2 == 1 ? half * half * x : half * half;
    } else {
      N = -N;
      double half = myPow(x, (int) N / 2);
      return N % 2 == 1 ? 1 / (half * half * x) : 1 / (half * half);
    }
  }
}
