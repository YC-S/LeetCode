/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/29
 */
public class P16_3SumClosest {

  public static int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int diff = Integer.MAX_VALUE, closest = 0;
    for (int k = 0; k < nums.length - 2; ++k) {
      for (int i = k + 1, j = nums.length - 1; i < j; ) {
        int sum = nums[k] + nums[i] + nums[j];
        if (sum == target) {
          return target;
        } else if (sum > target) {
          if (sum - target < diff) {
            diff = sum - target;
            closest = sum;
          }
          --j;
        } else {
          if (target - sum < diff) {
            diff = target - sum;
            closest = sum;
          }
          ++i;
        }
      }
    }
    return closest;
  }

  public static void main(String[] args) {
    int[] nums = {-1, 2, 1, -4};
    int target = 1;
    System.out.println(threeSumClosest(nums, target));
  }
}
