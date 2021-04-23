package company.others.heartdub;

public class findArray {
  public int findNthDigit(int n) {
    if (n <= 0) return n;
    long count = 1, base = 9, sum = 0;
    while (sum < n) {
      sum += count * base;
      count++;
      base *= 10;
    }
    count--;
    base /= 10;
    sum -= count * base;
    long offset = n - sum;
    long num = base / 9 + (offset - 1) / count;
    long mod = (offset - 1) % count;
    char[] array = Long.toString(num).toCharArray();
    return array[(int) mod] - '0';
  }
}
