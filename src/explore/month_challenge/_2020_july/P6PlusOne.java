/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_july;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/06
 */
public class P6PlusOne {

  public int[] plusOne(int[] digits) {
    int n = digits.length;
    int cnt9 = 0;
    for (int digit : digits) {
      if (digit == 9) {
        cnt9++;
      }
    }
    if (n == cnt9) {
      int[] res = new int[n + 1];
      res[0] = 1;
      return res;
    }

    boolean cur = true;
    for (int i = n - 1; i >= 0; i--) {
      if (cur) {
        digits[i]++;
        cur = false;
      }
      if (digits[i] == 10) {
        digits[i] = 0;
        cur = true;
      }
    }
    return digits;
  }
}
