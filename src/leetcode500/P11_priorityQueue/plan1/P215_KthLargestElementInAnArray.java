package leetcode500.P11_priorityQueue.plan1;

import java.util.PriorityQueue;

public class P215_KthLargestElementInAnArray {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);
    for (int num : nums) {
      pq.add(num);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    return pq.poll();
  }
}
