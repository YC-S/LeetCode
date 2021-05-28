package all_problems;

public class P1837_SumOfDigitsInBaseK {
  public int sumBase(int n, int k) {
    int sum = 0;
    while (n > 0) {
      sum += n % k;
      n /= k;
    }
    return sum;
  }
}
