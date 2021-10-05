package leetcode500.p22_dp.plan3;

import java.util.ArrayList;
import java.util.List;

public class P131_PalindromePartitioning {
  public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    if (s == null || s.length() == 0) return res;
    List<String> cur = new ArrayList<>();
    dfs(s, cur, res, 0);
    return res;
  }

  private void dfs(String s, List<String> cur, List<List<String>> res, int index) {
    if (index == s.length()) {
      res.add(new ArrayList<>(cur));
      return;
    }
    for (int i = index + 1; i <= s.length(); i++) {
      if (isValid(s.substring(index, i))) {
        cur.add(s.substring(index, i));
        dfs(s, cur, res, i);
        cur.remove(cur.size() - 1);
      }
    }
  }

  private boolean isValid(String s) {
    int i = 0, j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
