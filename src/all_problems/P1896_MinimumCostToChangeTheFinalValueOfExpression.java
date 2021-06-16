package all_problems;

import java.util.*;

public class P1896_MinimumCostToChangeTheFinalValueOfExpression {
  Map<Integer, Integer> map;

  public int minOperationsToFlip(String expression) {
    Stack<Integer> stack = new Stack<>();
    map = new HashMap<>();

    for (int i = 0; i < expression.length(); ++i) {
      if (expression.charAt(i) == '(') stack.push(i);
      else if (expression.charAt(i) == ')') map.put(stack.pop(), i);
    }

    return evaluate(expression, 0, expression.length() - 1)[1];
  }

  private int[] evaluate(String expression, int low, int high) {
    List<int[]> list = new ArrayList<>();
    List<Character> characters = new ArrayList<>();

    char c;
    int next;

    for (int i = low; i <= high; ++i) {
      c = expression.charAt(i);

      if (c == '0' || c == '1') {
        list.add(new int[] {c - '0', 1});
      } else if (c == '|' || c == '&') {
        characters.add(c);
      } else {
        next = map.get(i);
        list.add(evaluate(expression, i + 1, next - 1));
        i = next;
      }
    }

    int result = list.get(0)[0];

    for (int i = 1; i < list.size(); ++i) {
      if (characters.get(i - 1) == '&') result = result & list.get(i)[0];
      else result = result | list.get(i)[0];
    }

    int[] minChange = minChange(list, characters);

    return new int[] {result, minChange[result ^ 1]};
  }

  private int[] minChange(List<int[]> list, List<Character> vals) {
    int one = 0;
    int zero = 0;

    int pZero, pOne;

    if (list.get(0)[0] == 1) zero += list.get(0)[1];
    else one += list.get(0)[1];

    for (int i = 1, j = 0; i < list.size(); ++i, ++j) {
      pZero = zero;
      pOne = one;

      if (vals.get(j) == '|') {
        if (list.get(i)[0] == 0) {
          zero = Math.min(pZero, 1);
          one = Math.min(pOne, list.get(i)[1]);
        } else {
          zero = Math.min(pZero + 1, list.get(i)[1] + 1);
          one = 0;
        }
      } else {
        if (list.get(i)[0] == 0) {
          zero = 0;
          one = Math.min(1 + pOne, list.get(i)[1] + 1);
        } else {
          zero = Math.min(pZero, list.get(i)[1]);
          one = Math.min(pOne, 1);
        }
      }
    }

    return new int[] {zero, one};
  }
}
