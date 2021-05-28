package all_problems;

public class P1862_SumOfFlooredPairs {
  static final int MAX = (int) 1e5;
  static final int MODULUS = (int) 1e9 + 7;

  public int sumOfFlooredPairs(int[] nums) {
    int[] counts = new int[MAX + 1];
    for (int num : nums) {
      ++counts[num];
    }
    for (int i = 1; i <= MAX; ++i) {
      counts[i] += counts[i - 1];
    }

    long total = 0;
    for (int i = 1; i <= MAX; ++i) {
      if (counts[i] > counts[i - 1]) {
        long sum = 0;
        // [i * j, i * (j + 1)) would derive a quotient of j
        for (int j = 1; i * j <= MAX; ++j) {
          int lower = i * j - 1;
          int upper = i * (j + 1) - 1;
          sum += (counts[Math.min(upper, MAX)] - counts[lower]) * (long) j;
        }
        total = (total + (sum % MODULUS) * (counts[i] - counts[i - 1])) % MODULUS;
      }
    }
    return (int) total;
  }
}
