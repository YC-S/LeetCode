package leetcode500.P16_dfs.plan5;

import java.util.ArrayList;
import java.util.List;

public class P241_DifferentWaysToAddParentheses {
  public List<Integer> diffWaysToCompute(String expression) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < expression.length(); i++) {
      if (expression.charAt(i) == '-'
          || expression.charAt(i) == '*'
          || expression.charAt(i) == '+') {
        String part1 = expression.substring(0, i);
        String part2 = expression.substring(i + 1);
        List<Integer> part1Res = diffWaysToCompute(part1);
        List<Integer> part2Res = diffWaysToCompute(part2);
        for (int p1 : part1Res) {
          for (int p2 : part2Res) {
            int c = 0;
            switch (expression.charAt(i)) {
              case '+':
                c = p1 + p2;
                break;
              case '-':
                c = p1 - p2;
                break;
              case '*':
                c = p1 * p2;
                break;
            }
            res.add(c);
          }
        }
      }
    }
    if (res.size() == 0) {
      res.add(Integer.valueOf(expression));
    }
    return res;
  }
}
