package leetcode500.p34_math.plan1;

public class P204_CountPrimes {
  public int countPrimes(int n) {
    if (n <= 2) {
      return 0;
    }

    boolean[] numbers = new boolean[n];
    for (int p = 2; p <= (int) Math.sqrt(n); p++) {
      if (!numbers[p]) {
        for (int j = p * p; j < n; j += p) {
          numbers[j] = true;
        }
      }
    }

    int numberOfPrimes = 0;
    for (int i = 2; i < n; i++) {
      if (!numbers[i]) {
        numberOfPrimes++;
      }
    }

    return numberOfPrimes;
  }
}
