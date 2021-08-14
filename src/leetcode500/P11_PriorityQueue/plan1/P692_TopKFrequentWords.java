package leetcode500.P11_PriorityQueue.plan1;

import java.util.*;

public class P692_TopKFrequentWords {
  public List<String> topKFrequent(String[] words, int k) {
    List<String> res = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    PriorityQueue<Map.Entry<String, Integer>> pq =
        new PriorityQueue<>(
            (o1, o2) ->
                o1.getValue() != o2.getValue()
                    ? o2.getValue().compareTo(o1.getValue())
                    : o1.getKey().compareTo(o2.getKey()));
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      pq.offer(entry);
    }
    for (int i = 0; i < k; i++) {
      res.add(pq.poll().getKey());
    }
    return res;
  }
}
