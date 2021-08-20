package leetcode500.p18_bfs;

import java.util.*;

public class P126_WordLadderII {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> res = new ArrayList<>();
    if (wordList == null || wordList.size() == 0) return res;
    Set<String> set = new HashSet<>(wordList);
    if (!set.contains(endWord)) return res;

    Map<String, List<String>> graph = new HashMap<>();
    Set<String> curLevel = new HashSet<>();

    curLevel.add(beginWord);
    boolean foundEnd = false;

    while (!curLevel.isEmpty() && !foundEnd) {
      set.removeAll(curLevel);
      Set<String> nextLevel = new HashSet<>();
      for (String s : curLevel) {
        graph.put(s, new ArrayList<>());
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
          char tmp = arr[i];
          for (char c = 'a'; c <= 'z'; c++) {
            if (c == tmp) continue;
            arr[i] = c;
            String next = new String(arr);
            if (!set.contains(next)) continue;
            graph.get(s).add(next);
            nextLevel.add(next);
            if (next.equals(endWord)) {
              foundEnd = true;
            }
          }
          arr[i] = tmp;
        }
      }
      curLevel = nextLevel;
    }
    if (!foundEnd) return res;
    List<String> list = new ArrayList<>();
    list.add(beginWord);
    addPath(beginWord, endWord, res, graph, list);
    return res;
  }

  private void addPath(
      String from,
      String to,
      List<List<String>> res,
      Map<String, List<String>> graph,
      List<String> list) {
    if (from.equals(to)) {
      res.add(new ArrayList<>(list));
      return;
    }
    if (!graph.containsKey(from)) return;
    for (String next : graph.get(from)) {
      list.add(next);
      addPath(next, to, res, graph, list);
      list.remove(list.size() - 1);
    }
  }
}
