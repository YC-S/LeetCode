/*
 * Copyright (c) 2020. Yuanchen
 */

package arrays_101;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/22
 */
public class FindNumbersWithEvenNumberOfDigits {

  public int findNumbers(int[] nums) {

    if (nums == null || nums.length == 0) {
      return 0;
    }
    int count = 0;
    for (int num : nums) {
      int countDigits = 0;
      while (num != 0) {
        countDigits++;
        num /= 10;
      }
      if (countDigits % 2 == 0) {
        count++;
      }
    }
    return count;
  }
}
