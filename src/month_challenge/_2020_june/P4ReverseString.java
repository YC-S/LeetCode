/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_june;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/04
 */
public class P4ReverseString {

  public void reverseString(char[] s) {
    for (int i = 0; i < s.length / 2; i++) {
      char tmp = s[i];
      s[i] = s[s.length - 1 - i];
      s[s.length - 1 - i] = tmp;
    }
  }
}
