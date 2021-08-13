package leetcode500.P10_expression.plan1;

import java.util.ArrayDeque;
import java.util.Deque;

public class P224_BasicCalculator {
  public int calculate(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    int res = 0;
    int number = 0;
    int sign = 1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        number = 10 * number + (c - '0');
      } else if (c == '+') {
        res += sign * number;
        number = 0;
        sign = 1;
      } else if (c == '-') {
        res += sign * number;
        number = 0;
        sign = -1;
      } else if (c == '(') {
        stack.offerFirst(res);
        stack.offerFirst(sign);
        sign = 1;
        res = 0;
      } else if (c == ')') {
        res += sign * number;
        number = 0;
        res *= stack.pollFirst();
        res += stack.pollFirst();
      }
    }
    if (number != 0) {
      res += sign * number;
    }
    return res;
  }
}
