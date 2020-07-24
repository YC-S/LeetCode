/*
 * Copyright (c) 2020. Yuanchen
 */

package july_challenge;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/23
 */
public class P23SingleNumberIII {

  public int[] singleNumber(int[] nums) {
    int[] result = new int[2];
    int xor = nums[0];
    for (int i = 1; i < nums.length; i++) {
      xor ^= nums[i];
    }

    int bit = xor & ~(xor - 1);
    int num1 = 0;
    int num2 = 0;

    for (int num : nums) {
      if ((num & bit) > 0) {
        num1 ^= num;
      } else {
        num2 ^= num;
      }
    }

    result[0] = num1;
    result[1] = num2;
    return result;
  }
}
