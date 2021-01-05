/*
 * Copyright (c) 2020. Yuanchen
 */

package top100;

import java.util.*;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/08
 */
public class P347TopKFrequentElements {

  public int[] topKFrequent(int[] nums, int k) {
    // O(1) time
    if (k == nums.length) {
      return nums;
    }

    // 1. build hash map : character and how often it appears
    // O(N) time
    Map<Integer, Integer> count = new HashMap<>(10);
    for (int n : nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }

    // init heap 'the less frequent element first'
    Queue<Integer> heap = new PriorityQueue<>(
      Comparator.comparingInt(count::get));

    // 2. keep k top frequent elements in the heap
    // O(N log k) < O(N log N) time
    for (int n : count.keySet()) {
      heap.add(n);
      if (heap.size() > k) {
        heap.poll();
      }
    }

    // 3. build an output data_structures.array
    // O(k log k) time
    int[] top = new int[k];
    for (int i = k - 1; i >= 0; --i) {
      top[i] = heap.poll();
    }
    return top;
  }
}
