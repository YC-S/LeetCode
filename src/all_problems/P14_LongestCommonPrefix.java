package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/01
 */
public class P14_LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }
    int i = 0;
    int equal = 0;
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < strs.length; j++) {
      min = Math.min(min, strs[j].length());
    }
    while (i < min) {
      String tmp = strs[0];
      for (int j = 1; j < strs.length; j++) {
        if (tmp.charAt(i) != strs[j].charAt(i)) {
          return strs[0].substring(0, i);
        }
      }
      i++;
    }
    return strs[0].substring(0, i);
  }
}
