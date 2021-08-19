package leetcode500.P16_dfs.plan1;

import java.util.ArrayList;
import java.util.List;

public class P22_GenerateParentheses {
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    helper(res, n, 0, 0, sb);
    return res;
  }

  private void helper(List<String> res, int n, int left, int right, StringBuilder sb) {
    if (left == n && right == n) {
      res.add(sb.toString());
      return;
    }
    if (left < n) {
      sb.append('(');
      helper(res, n, left + 1, right, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (right < left) {
      sb.append(')');
      helper(res, n, left, right + 1, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
