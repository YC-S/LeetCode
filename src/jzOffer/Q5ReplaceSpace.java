/*
 * Copyright (c) 2020. Yuanchen
 */

package jzOffer;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/23
 */
public class Q5ReplaceSpace {

  public static String replaceSpace(StringBuffer str) {
    int p1 = str.length() - 1;
    for (int i = 0; i <= p1; i++) {
      if (str.charAt(i) == ' ') {
        str.append("  ");
      }
    }
    int p2 = str.length() - 1;
    while (p1 < p2 && p1 >= 0) {
      char c = str.charAt(p1--);
      if (c == ' ') {
        str.setCharAt(p2--, '0');
        str.setCharAt(p2--, '2');
        str.setCharAt(p2--, '%');
      } else {
        str.setCharAt(p2--, c);
      }
    }
    return new String(str);
  }

  public static void main(String[] args) {
    System.out.println(replaceSpace(new StringBuffer("A B")));
  }
}
