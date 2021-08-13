package leetcode500.P10_expression.plan1;

import java.util.ArrayDeque;
import java.util.Deque;

public class P150_EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (String t : tokens) {
      if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
        int right = stack.pollFirst();
        int left = stack.pollFirst();
        if (t.equals("+")) {
          stack.offerFirst(left + right);
        } else if (t.equals("-")) {
          stack.offerFirst(left - right);
        } else if (t.equals("*")) {
          stack.offerFirst(left * right);
        } else {
          stack.offerFirst(left / right);
        }
      } else {
        stack.offerFirst(Integer.valueOf(t));
      }
    }
    return stack.pollFirst();
  }
}
