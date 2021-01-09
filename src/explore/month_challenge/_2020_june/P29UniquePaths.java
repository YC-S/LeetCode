/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_june;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/29
 */
public class P29UniquePaths {

  public int uniquePaths(int m, int n) {
    int N = n + m - 2;// how much steps we need to do
    int k = m - 1; // number of steps that need to go down
    double res = 1;
    // here we calculate the total possible path number
    // Combination(N, k) = n! / (k!(n - k)!)
    // reduce the numerator and denominator and get
    // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
    for (int i = 1; i <= k; i++) {
      res = res * (N - k + i) / i;
    }
    return (int) res;
  }
}
