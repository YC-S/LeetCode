/*
 * Copyright (c) 2020. Yuanchen
 */

package august_challenge;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/03
 */
public class P4IsPalindrome {

  public boolean isPalindrome(String s) {
    if (s == null) {
      return false;
    }
    s = s.replaceAll("[^a-zA-Z0-9]", "").trim().toLowerCase();
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }
}
