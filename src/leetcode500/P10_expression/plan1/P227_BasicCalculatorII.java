package leetcode500.P10_expression.plan1;

import java.util.ArrayDeque;
import java.util.Deque;

public class P227_BasicCalculatorII {
  public int calculate(String s) {
    if (s == null || s.length() == 0) return 0;
    char[] array = s.toCharArray();
    Deque<Integer> stack = new ArrayDeque<>();
    char sign = '+';
    int num = 0;
    for (int i = 0; i < array.length; i++) {
      if (Character.isDigit(array[i])) num = num * 10 + array[i] - '0';
      if ((!Character.isDigit(array[i]) && ' ' != array[i]) || i == array.length - 1) {
        if (sign == '+') stack.offerFirst(num);
        else if (sign == '-') stack.offerFirst(-num);
        else if (sign == '*') stack.offerFirst(stack.pollFirst() * num);
        else if (sign == '/') stack.offerFirst(stack.pollFirst() / num);
        num = 0;
        sign = array[i];
      }
    }
    int res = 0;
    for (int i : stack) {
      res += i;
    }
    return res;
  }
}
