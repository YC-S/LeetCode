package leetcode500.P16_dfs.plan3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P291_WordPatternII {
  public boolean wordPatternMatch(String pattern, String str) {
    return helper(pattern, str, new HashMap<>(), new HashSet<>());
  }

  private boolean helper(
      String pattern, String str, Map<Character, String> map, Set<String> taken) {
    if (pattern.isEmpty() || str.isEmpty()) {
      return pattern.isEmpty() && str.isEmpty();
    }

    char subPattern = pattern.charAt(0);
    if (map.containsKey(subPattern)) {
      if (!str.startsWith(map.get(subPattern))) {
        return false;
      }

      return helper(pattern.substring(1), str.substring(map.get(subPattern).length()), map, taken);
    }

    StringBuilder patternVal = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      patternVal.append(str.charAt(i));
      String patternValStr = patternVal.toString();
      if (taken.contains(patternValStr)) {
        continue;
      }
      taken.add(patternValStr);
      map.put(subPattern, patternValStr);

      if (helper(pattern.substring(1), str.substring(patternValStr.length()), map, taken)) {
        return true;
      }
      taken.remove(patternValStr);
      map.remove(subPattern);
    }

    return false;
  }
}
