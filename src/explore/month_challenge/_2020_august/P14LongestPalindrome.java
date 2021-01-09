/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_august;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/14
 */
public class P14LongestPalindrome {

  public int longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int count = 0;

    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      if (set.contains(s.charAt(i))) {
        set.remove(s.charAt(i));
        count++;
      } else {
        set.add(s.charAt(i));
      }
    }
    return set.isEmpty() ? count * 2 : count * 2 + 1;
  }

}
