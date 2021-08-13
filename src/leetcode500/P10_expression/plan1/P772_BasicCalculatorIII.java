package leetcode500.P10_expression.plan1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P772_BasicCalculatorIII {
  public int calculate(String s) {
    if (s == null) {
      return 0;
    }
    Queue<Character> q = new LinkedList<>();
    for (char c : s.toCharArray()) {
      q.offer(c);
    }
    q.offer('+');
    return cal(q);
  }

  private int cal(Queue<Character> q) {
    char sign = '+';
    int num = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    while (!q.isEmpty()) {
      char c = q.poll();
      if (c == ' ') {
        continue;
      }
      if (Character.isDigit(c)) {
        num = 10 * num + c - '0';
      } else if (c == '(') {
        num = cal(q);
      } else {
        if (sign == '+') {
          stack.offerFirst(num);
        } else if (sign == '-') {
          stack.offerFirst(-num);
        } else if (sign == '*') {
          stack.offerFirst(stack.pollFirst() * num);
        } else if (sign == '/') {
          stack.offerFirst(stack.pollFirst() / num);
        }
        num = 0;
        sign = c;
        if (c == ')') {
          break;
        }
      }
    }
    int sum = 0;
    while (!stack.isEmpty()) {
      sum += stack.pollFirst();
    }
    return sum;
  }
}
