package contest.leetcode.双周赛._b_57;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A {
  public boolean areOccurrencesEqual(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    List<Integer> list = new ArrayList<>();
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      list.add(entry.getValue());
    }
    int count = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      if (count != list.get(i)) return false;
    }
    return true;
  }
}
