/*
 * Copyright (c) 2020. Yuanchen
 */

package arrays_101;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/24
 */
public class MaxConsecutiveOnesII {

  public static int findMaxConsecutiveOnes(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int i = 0, j = 0, countZero = 0, max = 0;
    while (j < nums.length) {
      if (nums[j] == 1) {
        j++;
        max = Math.max(max, j - i);
      } else if (countZero < 1) {
        j++;
        countZero++;
        max = Math.max(max, j - i);
      } else if (nums[i++] == 0) {
        countZero--;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 0, 1, 1, 0, 1};
    System.out.println(findMaxConsecutiveOnes(arr));
  }
}
