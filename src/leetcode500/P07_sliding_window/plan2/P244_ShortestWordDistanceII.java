package leetcode500.P07_sliding_window.plan2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P244_ShortestWordDistanceII {
  Map<String, List<Integer>> map;

  public P244_ShortestWordDistanceII(String[] wordDict) {
    map = new HashMap<>();
    for (int i = 0; i < wordDict.length; i++) {
      if (!map.containsKey(wordDict[i])) {
        map.put(wordDict[i], new ArrayList<>());
      }
      map.get(wordDict[i]).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    int p1 = -1, p2 = -1;
    int diff = Integer.MAX_VALUE;
    List<Integer> l1 = map.get(word1);
    List<Integer> l2 = map.get(word2);
    for (int i = 0; i < l1.size(); i++) {
      for (int j = 0; j < l2.size(); j++) {
        diff = Math.min(diff, Math.abs(l1.get(i) - l2.get(j)));
      }
    }
    return diff;
  }
}
