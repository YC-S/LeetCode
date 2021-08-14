package leetcode500.P11_PriorityQueue.plan1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P347_TopKFrequentElements {
  public int[] topKFrequent(int[] nums, int k) {
    if (k == nums.length) return nums;

    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
    for (int n : map.keySet()) {
      heap.add(n);
      if (heap.size() > k) heap.poll();
    }

    int[] res = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      res[i] = heap.poll();
    }
    return res;
  }
}
