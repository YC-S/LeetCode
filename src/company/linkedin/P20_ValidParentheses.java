package company.linkedin;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P20_ValidParentheses {
  public static boolean isValid(String s) {
    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put(']', '[');
    map.put('}', '{');
    Deque<Character> stack = new ArrayDeque<>();
    char[] arr = s.toCharArray();
    for (char c : arr) {
      if (stack.isEmpty()) {
        stack.offerFirst(c);
      } else if (map.get(c) == stack.peekFirst()) {
        stack.pollFirst();
      } else {
        stack.offerFirst(c);
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(isValid("([)]"));
  }
}
