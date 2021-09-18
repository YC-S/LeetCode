package leetcode500.P16_dfs.plan2;

import java.util.ArrayList;
import java.util.List;

public class P77_Combinations {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (k > n || k < 0) {
      return result;
    }
    if (k == 0) {
      result.add(new ArrayList<Integer>());
      return result;
    }
    result = combine(n - 1, k - 1);
    for (List<Integer> list : result) {
      list.add(n);
    }
    result.addAll(combine(n - 1, k));
    return result;
  }
}
