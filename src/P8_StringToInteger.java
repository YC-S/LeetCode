/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/01
 */
public class P8_StringToInteger {

  public int myAtoi(String str) {
    if (str == null) {
      return 0;
    }
    str = str.trim();
    if (str.length() == 0) {
      return 0;
    }
    int index = 0;
    int sign = 1;
    int total = 0;

    if (str.charAt(index) == '+' || str.charAt(index) == '-') {
      sign = str.charAt(index) == '+' ? 1 : -1;
      index++;
    }

    while (index < str.length()) {
      int digit = str.charAt(index) - '0';
      if (digit < 0 || digit > 9) {
        break;
      }

      //check if total will be overflow after 10 times and add digit
      if (Integer.MAX_VALUE / 10 < total
        || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }

      total = 10 * total + digit;
      index++;
    }
    return total * sign;
  }
}
