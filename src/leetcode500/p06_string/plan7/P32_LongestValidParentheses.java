package leetcode500.p06_string.plan7;

import java.util.ArrayDeque;
import java.util.Deque;

public class P32_LongestValidParentheses {
  public int longestValidParentheses(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    int res = 0;
    stack.offerFirst(-1);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peekFirst()) == '(') {
        stack.pollFirst();
        res = Math.max(res, i - stack.peekFirst());
      } else {
        stack.offerFirst(i);
      }
    }
    return res;
  }
}
