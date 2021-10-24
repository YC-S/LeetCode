package leetcode500.p06_string.plan7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P20_ValidParentheses {
  public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put(']', '[');
    map.put('}', '{');
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.offerFirst('(');
      } else if (s.charAt(i) == '[') {
        stack.offerFirst('[');
      } else if (s.charAt(i) == '{') {
        stack.offerFirst('{');
      } else if (s.charAt(i) == ')') {
        if (stack.peekFirst() != map.get(')')) return false;
        stack.pollFirst();
      } else if (s.charAt(i) == ']') {
        if (stack.peekFirst() != map.get(']')) return false;
        stack.pollFirst();
      } else if (s.charAt(i) == '}') {
        if (stack.peekFirst() != map.get('}')) return false;
        stack.pollFirst();
      }
    }
    return stack.isEmpty();
  }
}
