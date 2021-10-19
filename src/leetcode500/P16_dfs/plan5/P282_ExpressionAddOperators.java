package leetcode500.P16_dfs.plan5;

import java.util.ArrayList;
import java.util.List;

public class P282_ExpressionAddOperators {
  public List<String> addOperators(String num, int target) {
    List<String> res = new ArrayList<>();
    if (num == null || num.length() == 0) return res;
    dfs(res, "", num, target, 0, 0, 0);
    return res;
  }

  private void dfs(
      List<String> res, String path, String num, int target, int pos, long eval, long multed) {
    if (pos == num.length()) {
      if (target == eval) {
        res.add(path);
      }
      return;
    }
    for (int i = pos; i < num.length(); i++) {
      if (i != pos && num.charAt(pos) == '0') break;
      long cur = Long.parseLong(num.substring(pos, i + 1));
      if (pos == 0) {
        dfs(res, path + cur, num, target, i + 1, cur, cur);
      } else {
        dfs(res, path + "+" + cur, num, target, i + 1, eval + cur, cur);
        dfs(res, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
        dfs(res, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
      }
    }
  }
}
