package leetcode500.P16_dfs.plan4;

import java.util.ArrayList;
import java.util.List;

public class P254_FactorCombinations {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    dfs(n, cur, res, 2);
    return res;
  }

  private void dfs(int n, List<Integer> cur, List<List<Integer>> res, int start) {
    if (n <= 1) {
      if (cur.size() > 1) {
        res.add(new ArrayList<>(cur));
      }
      return;
    }
    for (int i = start; i <= n; i++) {
      if (n % i == 0) {
        cur.add(i);
        dfs(n / i, cur, res, i);
        cur.remove(cur.size() - 1);
      }
    }
  }
}
