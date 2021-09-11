package leetcode500.p06_string.plan2;

import java.util.Arrays;

public class P66_PlusOne {
  public int[] plusOne(int[] digits) {
    int carry = 0;
    int n = digits.length;
    digits[n - 1]++;
    for (int i = n - 1; i >= 0; i--) {
      if (digits[i] == 10) {
        digits[i] = 0;
        if (i >= 1) {
          digits[i - 1]++;
        } else {
          carry = 1;
        }
      } else {
        break;
      }
    }
    if (carry == 1) {
      int[] res = new int[n + 1];
      Arrays.fill(res, 0);
      res[0] = 1;
      return res;
    } else {
      return digits;
    }
  }
}
