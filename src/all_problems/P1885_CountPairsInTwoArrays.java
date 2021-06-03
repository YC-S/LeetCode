package all_problems;

import java.util.Arrays;

public class P1885_CountPairsInTwoArrays {
  public long countPairs(int[] nums1, int[] nums2) {
    // i < j only means you have to use 2 different positions and count them once.
    int N = nums1.length;
    int[] nums = new int[N];
    for (int i = 0; i < N; i++) nums[i] = nums1[i] - nums2[i];
    Arrays.sort(nums);

    // Count 2 items from the diff array that sums greater than zero.
    long count = 0;
    for (int l = 0; l < N - 1; l++) {
      count += N - findR(l, nums);
    }
    return count;
  }

  // min r that make nums[l] + nums[r] > 0
  private int findR(int l, int[] nums) {
    int start = l + 1;
    int end = nums.length - 1;
    while (start <= end) {
      int r = start + (end - start) / 2;
      if (nums[l] + nums[r] > 0) {
        end = r - 1;
      } else {
        start = r + 1;
      }
    }
    return end + 1; // covers r == N when r does not exists
  }
}
