package all_problems;

import java.util.Arrays;

public class P1775_EqualSumArraysWithMinimumNumberOfOperations {
  public int minOperations(int[] nums1, int[] nums2) {
    if (nums1.length * 6 < nums2.length || nums1.length > 6 * nums2.length) {
      return -1;
    }
    int sum1 = Arrays.stream(nums1).sum(), sum2 = Arrays.stream(nums2).sum();
    if (sum1 < sum2) return minOperations(nums1, nums2, sum1, sum2);
    return minOperations(nums2, nums1, sum2, sum1);
  }

  private int minOperations(int[] n1, int[] n2, int sum1, int sum2) {
    int[] cnt = new int[6];
    int diff = sum2 - sum1;
    int res = 0;
    for (int n : n1) {
      ++cnt[6 - n];
    }
    for (int n : n2) {
      ++cnt[n - 1];
    }
    for (int i = 5; i > 0 && diff >= 0; --i) {
      int take = Math.min(cnt[i], diff / i + (diff % i != 0 ? 1 : 0));
      diff -= take * i;
      res += take;
    }
    return res;
  }
}
