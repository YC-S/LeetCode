package leetcode500.p05_hashmap.plan1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P249_GroupShiftedStrings {
  public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strings) {
      StringBuilder sb = new StringBuilder();
      if (s.length() > 0) {
        int base = s.charAt(0) - 'a';
        sb.append('a');
        for (int i = 1; i < s.length(); i++) {
          char c = (char) (s.charAt(i) - base);
          if (c < 'a') c += 26;
          sb.append(c);
        }
      }
      map.putIfAbsent(sb.toString(), new ArrayList<>());
      map.get(sb.toString()).add(s);
    }
    return new ArrayList<>(map.values());
  }
}
