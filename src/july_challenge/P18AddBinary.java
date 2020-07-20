/*
 * Copyright (c) 2020. Yuanchen
 */

package july_challenge;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/19
 */
public class P18AddBinary {

  public String addBinary(String a, String b) {
    int n = a.length(), m = b.length();
    if (m > n) {
      return addBinary(b, a);
    }
    int l = Math.max(n, m);

    StringBuilder sb = new StringBuilder();
    int carry = 0, j = m - 1;
    for (int i = l - 1; i > -1; --i) {
      if (a.charAt(i) == '1') {
        ++carry;
      }
      if (j > -1 && b.charAt(j--) == '1') {
        ++carry;
      }

      if (carry % 2 == 1) {
        sb.append('1');
      } else {
        sb.append('0');
      }

      carry /= 2;
    }
    if (carry == 1) {
      sb.append('1');
    }
    sb.reverse();

    return sb.toString();
  }
}
