/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.arrays_101;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/24
 */
public class RemoveDuplicatesFromSortedArray {

  public static int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int i = 0, j = 0;
    while (j < nums.length) {
      if (nums[i] == nums[j]) {
        j++;
      } else {
        if (i == j - 1) {
          j++;
          i++;
        } else {
          nums[++i] = nums[j];
          j++;
        }
      }
    }
    return i + 1;
  }

  public static int removeDuplicates2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int i = 0, j = 1;
    while (j < nums.length) {
      if (nums[i] == nums[j]) {
        j++;
      } else {
        if (i == j - 1) {
          i++;
          j++;
        } else {
          i++;
          nums[i] = nums[j];
          j++;
        }
      }
    }
    return i + 1;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 1, 2};
    int[] nums1 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    System.out.println(removeDuplicates2(nums));
    System.out.println(removeDuplicates2(nums1));
  }
}
