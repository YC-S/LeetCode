package leetcode500.p34_math.plan1;

public class P172_FactorialTrailingZeroes {
  public int trailingZeroes(int n) {
    int count = 0;
    while (n > 0) {
      n /= 5;
      count += n;
    }
    return count;
  }
}
