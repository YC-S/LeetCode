/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_august;

import java.util.Stack;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/16
 */
public class P15FindPermutation {

  public int[] findPermutation(String s) {
    int[] res = new int[s.length() + 1];
    Stack<Integer> stack = new Stack<>();
    int j = 0;
    for (int i = 1; i <= s.length(); i++) {
      if (s.charAt(i - 1) == 'I') {
        stack.push(i);
        while (!stack.isEmpty()) {
          res[j++] = stack.pop();
        }
      } else {
        stack.push(i);
      }
    }
    stack.push(s.length() + 1);
    while (!stack.isEmpty()) {
      res[j++] = stack.pop();
    }
    return res;
  }
}
