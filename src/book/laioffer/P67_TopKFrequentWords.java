package book.laioffer;

import java.util.*;

public class P67_TopKFrequentWords {
  public static String[] topKFrequent(String[] combo, int k) {
    String[] res = new String[k];
    Map<String, Integer> map = new HashMap<>();
    for (String str : combo) {
      map.put(str, map.getOrDefault(str, 0) + 1);
    }
    PriorityQueue<Map.Entry<String, Integer>> pq =
        new PriorityQueue<>(
            new Comparator<Map.Entry<String, Integer>>() {
              @Override
              public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
              }
            });
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      pq.offer(entry);
    }
    int count = 0;
    for (int i = 0; i < k; i++) {
      if (pq.size() > 0) {
        res[i] = pq.poll().getKey();
        count++;
      } else {
        break;
      }
    }
    if (count < k) {
      res = Arrays.copyOf(res, count);
    }
    return res;
  }

  public static void main(String[] args) {
    String[] combo = {"hello", "world", "hi", "hello", "world", "nio", "iron", "chicago"};
    String[] combo1 = {"d", "a", "c", "b", "d", "a", "b", "b", "a", "d", "d", "a", "d"};
    System.out.println(Arrays.toString(combo));
    System.out.println(Arrays.toString(topKFrequent(combo, 3)));
    System.out.println(Arrays.toString(topKFrequent(combo1, 5)));
  }
}
