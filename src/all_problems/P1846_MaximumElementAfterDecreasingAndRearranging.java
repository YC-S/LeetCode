package all_problems;

import java.util.Arrays;

public class P1846_MaximumElementAfterDecreasingAndRearranging {
  public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
    Arrays.sort(arr);
    int pre = 0;
    for (int a : arr) pre = Math.min(pre + 1, a);
    return pre;
  }
}
