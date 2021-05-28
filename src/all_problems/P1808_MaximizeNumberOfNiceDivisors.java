package all_problems;

public class P1808_MaximizeNumberOfNiceDivisors {
  int MOD = (int) (1e9 + 7);

  public int maxNiceDivisors(int n) {
    if (n <= 3) return n;

    long divisorCount = 1L;
    int remainder = n % 3;

    if (remainder == 0) {
      divisorCount = power(3, n / 3);

    } else if (remainder == 1) {
      divisorCount = 4 * power(3, (n - 4) / 3);

    } else if (remainder == 2) {
      divisorCount = 2 * power(3, n / 3);
    }

    return (int) (divisorCount % MOD);
  }

  private long power(long num, long exp) {
    if (exp == 1) return num;
    if (exp == 0) return 1;

    long k1 = power(num, exp / 2);
    if (exp % 2 == 0) {
      return (k1 * k1) % MOD;
    } else {
      return (k1 * k1 * num) % MOD;
    }
  }
}
