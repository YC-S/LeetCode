/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_july;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/26
 */
public class P25FindMinimumInRotatedArray {

  public int findMin(int[] nums) {
    int lo = 0;
    int hi = nums.length - 1;
    int mid = 0;

    while (lo < hi) {
      mid = lo + (hi - lo) / 2;

      if (nums[mid] > nums[hi]) {
        lo = mid + 1;
      } else if (nums[mid] < nums[hi]) {
        hi = mid;
      } else { // when num[mid] and num[hi] are same
        hi--;
      }
    }
    return nums[lo];
  }
}
