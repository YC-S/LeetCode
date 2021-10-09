package leetcode500.p06_string.plan4;

import java.util.*;

public class P49_GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> res = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] arr = str.toCharArray();
      Arrays.sort(arr);
      String tmp = new String(arr);
      if (!map.containsKey(tmp)) {
        map.put(tmp, new ArrayList<>());
      }
      map.get(tmp).add(str);
    }
    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      res.add(entry.getValue());
    }
    return res;
  }
}
