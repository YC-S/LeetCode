/*
 * Copyright (c) 2020. Yuanchen
 */

package arrays_101;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/23
 */
public class RemoveElement {

  public static int removeElement(int[] nums, int val) {
    int i = 0;
    int j = nums.length - 1;
    int count = 0;
    while (i <= j) {
      if (nums[j] == val) {
        j--;
      } else if (nums[i] == val) {
        swap(nums, i++, j--);
        count++;
      } else if (nums[i] != val) {
        i++;
        count++;
      }
    }
    return count;
  }

  private static void swap(int[] nums, int a, int b) {
    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }

  public static void main(String[] args) {
//    int[] nums = {3, 2, 2, 3};
    int[] nums1 = {0, 1, 2, 2, 3, 0, 4, 2};
//    System.out.println(removeElement(nums, 3));
    System.out.println(removeElement(nums1, 2));
//    System.out.println(Arrays.toString(nums));
    System.out.println(Arrays.toString(nums1));
  }
}
