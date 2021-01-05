/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.arrays_101;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/22
 */
public class MaxConsecutiveOnes {

  public static void main(String[] args) {
    int[] nums = {1, 0, 1, 0, 1, 1};
    int[] nums1 = {1, 1, 1, 1, 1, 1};
  }

  public int findMaxConsecutiveOnes(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int cur = 0;
    int max = 0;
    if (nums.length == 1 && nums[0] == 1) {
      cur = 1;
      max = 1;
    }
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == 1 && nums[i - 1] == 1) {
        cur++;
        max = Math.max(cur, max);
      } else if (nums[i] == 0) {
        cur = 0;
      } else if (nums[i] == 1) {
        cur = 1;
        max = Math.max(cur, max);
      }
    }
    return max;
  }

}
