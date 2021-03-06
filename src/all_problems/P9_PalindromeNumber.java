package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/01
 */
public class P9_PalindromeNumber {

  public boolean isPalindrome(int x) {
    if (x < 0 || (x != 0 && x % 10 == 0)) {
      return false;
    }
    int rev = 0;
    while (x > rev) {
      rev = rev * 10 + x % 10;
      x = x / 10;
    }
    return (x == rev || x == rev / 10);
  }
}
