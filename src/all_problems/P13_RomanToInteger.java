package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/01
 */
public class P13_RomanToInteger {

  public int romanToInt(String s) {
    int sum = 0;
    if (s.contains("IV")) {
      sum -= 2;
    }
    if (s.contains("IX")) {
      sum -= 2;
    }
    if (s.contains("XL")) {
      sum -= 20;
    }
    if (s.contains("XC")) {
      sum -= 20;
    }
    if (s.contains("CD")) {
      sum -= 200;
    }
    if (s.contains("CM")) {
      sum -= 200;
    }

    char[] c = s.toCharArray();
    int count = 0;

    for (; count <= s.length() - 1; count++) {
      if (c[count] == 'M') {
        sum += 1000;
      }
      if (c[count] == 'D') {
        sum += 500;
      }
      if (c[count] == 'C') {
        sum += 100;
      }
      if (c[count] == 'L') {
        sum += 50;
      }
      if (c[count] == 'X') {
        sum += 10;
      }
      if (c[count] == 'V') {
        sum += 5;
      }
      if (c[count] == 'I') {
        sum += 1;
      }

    }

    return sum;
  }
}
