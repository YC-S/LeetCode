/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.recursion_101;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/02
 */
public class ReverseString {

  public static void reverseString(char[] s) {
    helper(s, 0, s.length - 1);
  }

  private static void helper(char[] s, int left, int right) {
    if (left >= right) {
      return;
    }
    char tmp = s[left];
    s[left++] = s[right];
    s[right--] = tmp;
    helper(s, left, right);
  }

  public static void main(String[] args) {
    char[] input = {'h', 'e', 'l', 'l', 'o'};
    reverseString(input);
    System.out.println(input);
  }
}
