package leetcode500.P10_expression.plan1;

import java.util.ArrayDeque;
import java.util.Deque;

public class P439_TernaryExpressionParser {
  public String parseTernary(String expression) {
    if (expression == null || expression.length() == 0) return "";
    Deque<Character> s = new ArrayDeque<>();
    for (int i = expression.length() - 1; i > 0; i--) {
      char element = expression.charAt(i);
      if (element != '?') {
        s.offerFirst(element);
      } else {
        char first = s.pollFirst();
        s.pop();
        char second = s.pollFirst();
        if (expression.charAt(i - 1) == 'T') {
          s.offerFirst(first);
        } else {
          s.offerFirst(second);
        }
        i--;
      }
    }
    return "" + s.pollFirst();
  }
}
