/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_may;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/05/22
 */
public class P22SortCharactersByFrequency {

  public static String frequencySort(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    Queue<Entry<Character, Integer>> queue = new PriorityQueue<>(
      s.length(),
      (a, b) -> b.getValue() - a.getValue()
    );
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.putIfAbsent(s.charAt(i), 0);
      map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
    }
    queue.addAll(map.entrySet());
    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      Map.Entry<Character, Integer> entry = queue.poll();
      for (int i = 0; i < entry.getValue(); i++) {
        sb.append(entry.getKey());
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(frequencySort("tree"));
    System.out.println(frequencySort("cccaaa"));
    System.out.println(frequencySort("Aabb"));
  }
}
