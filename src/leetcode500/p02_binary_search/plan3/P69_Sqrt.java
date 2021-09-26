package leetcode500.p02_binary_search.plan3;

public class P69_Sqrt {
  public int mySqrt(int x) {
    if (x < 2) return x;
    int left = 0, right = x / 2;
    long num;
    while (left <= right) {
      int pivot = left + (right - left) / 2;
      num = (long) pivot * pivot;
      if (num == x) return pivot;
      else if (num < x) left = pivot + 1;
      else right = pivot - 1;
    }
    return right;
  }
}
