package leetcode500.P16_dfs.plan5;

import java.util.*;

public class P425_WordSquares {
  public List<List<String>> wordSquares(String[] words) {
    List<List<String>> res = new ArrayList<>();
    if (words.length == 0 || words[0].length() == 0) return res;
    Map<String, Set<String>> map = new HashMap<>();
    int squareLen = words[0].length();
    for (String word : words) {
      for (int i = -1; i < words[0].length(); i++) {
        map.putIfAbsent(word.substring(0, i + 1), new HashSet<>());
        map.get(word.substring(0, i + 1)).add(word);
      }
    }
    dfs(res, new ArrayList<>(), 0, squareLen, map);
    return res;
  }

  private void dfs(
      List<List<String>> res, List<String> cur, int index, int len, Map<String, Set<String>> map) {
    if (index == len) {
      res.add(new ArrayList<>(cur));
      return;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i <= index - 1; i++) sb.append(cur.get(i).charAt(index));
    Set<String> candidates = map.get(sb.toString());
    if (candidates == null) return;
    for (String candidate : candidates) {
      cur.add(candidate);
      dfs(res, cur, index + 1, len, map);
      cur.remove(cur.size() - 1);
    }
  }
}
