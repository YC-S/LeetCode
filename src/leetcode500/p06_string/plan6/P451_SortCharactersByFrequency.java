package leetcode500.p06_string.plan6;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P451_SortCharactersByFrequency {
  public String frequencySort(String s) {
    char[] array = s.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    for (char c : array) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Map.Entry<Character, Integer>> pq =
        new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      pq.offer(entry);
    }
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      Map.Entry<Character, Integer> entry = pq.poll();
      int val = entry.getValue();
      char key = entry.getKey();
      for (int i = 0; i < val; i++) {
        sb.append(key);
      }
    }
    return sb.toString();
  }
}
