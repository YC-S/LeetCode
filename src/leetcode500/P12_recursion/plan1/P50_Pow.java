package leetcode500.P12_recursion.plan1;

public class P50_Pow {
  public double myPow(double x, int n) {
    long N = n;
    if (N < 0) {
      x = 1 / x;
      N = -N;
    }
    return helper(x, N);
  }

  private double helper(double x, long n) {
    if (n == 0) return 1.0;
    double half = helper(x, n / 2);
    return n % 2 == 1 ? half * half * x : half * half;
  }
}
