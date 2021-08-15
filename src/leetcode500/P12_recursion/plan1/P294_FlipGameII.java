package leetcode500.P12_recursion.plan1;

import java.util.HashMap;
import java.util.Map;

public class P294_FlipGameII {
  public boolean canWin(String currentState) {
    Map<String, Boolean> map = new HashMap<>();
    return dfs(currentState, map);
  }

  private boolean dfs(String s, Map<String, Boolean> map) {
    if (map.containsKey(s)) return map.get(s);
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb2 = sb.replace(i, i + 2, "--");
        if (!dfs(sb2.toString(), map)) {
          map.put(s, true);
          return true;
        }
      }
    }
    map.put(s, false);
    return false;
  }
}
