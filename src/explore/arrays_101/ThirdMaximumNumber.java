/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.arrays_101;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/24
 */
public class ThirdMaximumNumber {

  public static int thirdMax(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    int largest = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;
    int thirdMax = Integer.MIN_VALUE;
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
      if (nums[i] == largest || nums[i] == secondMax || nums[i] == thirdMax) {
        continue;
      }
      if (nums[i] > largest) {
        thirdMax = secondMax;
        secondMax = largest;
        largest = nums[i];
      } else if (nums[i] > secondMax) {
        thirdMax = secondMax;
        secondMax = nums[i];
      } else if (nums[i] > thirdMax) {
        thirdMax = nums[i];
      }
    }
    if (set.size() == 3) {
      return thirdMax;
    }
    if (thirdMax == Integer.MIN_VALUE) {
      return largest;
    }
    return thirdMax;

  }

  public static void main(String[] args) {
    System.out.println(thirdMax(new int[]{3, 2, 1}));
    System.out.println(thirdMax(new int[]{1, 2}));
    System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
    System.out.println(thirdMax(new int[]{1, 1, 2}));
    System.out.println(thirdMax(new int[]{1, 2, 2, 5, 3, 5}));
    System.out.println(thirdMax(new int[]{1, 2, -2147483648}));
  }
}
