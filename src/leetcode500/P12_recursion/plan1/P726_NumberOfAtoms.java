package leetcode500.P12_recursion.plan1;

import java.util.*;

public class P726_NumberOfAtoms {
  public String countOfAtoms(String formula) {
    Deque<Map<String, Integer>> stack = new ArrayDeque<>();
    Map<String, Integer> map = new HashMap<>();
    int i = 0, n = formula.length();
    while (i < n) {
      char c = formula.charAt(i);
      i++;
      if (c == '(') {
        stack.offerFirst(map);
        map = new HashMap<>();
      } else if (c == ')') {
        int val = 0;
        while (i < n && Character.isDigit(formula.charAt(i)))
          val = val * 10 + formula.charAt(i++) - '0';

        if (val == 0) val = 1;
        if (!stack.isEmpty()) {
          Map<String, Integer> temp = map;
          map = stack.pollFirst();
          for (String key : temp.keySet())
            map.put(key, map.getOrDefault(key, 0) + temp.get(key) * val);
        }
      } else {
        int start = i - 1;
        while (i < n && Character.isLowerCase(formula.charAt(i))) {
          i++;
        }
        String s = formula.substring(start, i);
        int val = 0;
        while (i < n && Character.isDigit(formula.charAt(i)))
          val = val * 10 + formula.charAt(i++) - '0';
        if (val == 0) val = 1;
        map.put(s, map.getOrDefault(s, 0) + val);
      }
    }
    StringBuilder sb = new StringBuilder();
    List<String> list = new ArrayList<>(map.keySet());
    Collections.sort(list);
    for (String key : list) {
      sb.append(key);
      if (map.get(key) > 1) sb.append(map.get(key));
    }
    return sb.toString();
  }
}
