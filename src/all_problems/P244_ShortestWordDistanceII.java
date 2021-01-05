package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/01
 */
public class P244_ShortestWordDistanceII {

  HashMap<String, List<Integer>> map;

  public P244_ShortestWordDistanceII(String[] words) {
    map = new HashMap();
    for (int i = 0; i < words.length; i++) {
      List<Integer> indexes = map.getOrDefault(words[i], new ArrayList());
      indexes.add(i);
      map.put(words[i], indexes);
    }
  }

  public int shortest(String word1, String word2) {
    List<Integer> p1 = map.get(word1);
    List<Integer> p2 = map.get(word2);
    int min = Integer.MAX_VALUE;
    int i = 0, j = 0;
    while (i < p1.size() && j < p2.size()) {
      int wp1 = p1.get(i);
      int wp2 = p2.get(j);
      if (wp1 < wp2) {
        min = Math.min(min, wp2 - wp1);
        i++;
      } else {
        min = Math.min(min, wp1 - wp2);
        j++;
      }
    }
    return min;
  }
}
