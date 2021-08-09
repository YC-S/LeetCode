package leetcode500.sliding_window.plan0;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class P480_SlidingWindowMedian {
  public double[] medianSlidingWindow(int[] nums, int k) {
    double[] result = new double[nums.length - k + 1];
    Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> minHeap = new PriorityQueue<>();

    for (int i = 0; i < nums.length; i++) {
      insert(nums[i], maxHeap, minHeap);
      if (i - k + 1 >= 0) {
        result[i - k + 1] = getMedian(maxHeap, minHeap);
        remove(nums[i - k + 1], maxHeap, minHeap);
      }
    }
    return result;
  }

  private void insert(int num, Queue<Integer> maxHeap, Queue<Integer> minHeap) {
    if (maxHeap.isEmpty() || maxHeap.peek() >= num) maxHeap.offer(num);
    else minHeap.offer(num);
    rebalance(maxHeap, minHeap);
  }

  private void rebalance(Queue<Integer> maxHeap, Queue<Integer> minHeap) {
    if (minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
    else if (maxHeap.size() > minHeap.size() + 1) minHeap.offer(maxHeap.poll());
  }

  private void remove(int num, Queue<Integer> maxHeap, Queue<Integer> minHeap) {
    if (num <= maxHeap.peek()) maxHeap.remove(num);
    else minHeap.remove(num);
    rebalance(maxHeap, minHeap);
  }

  private double getMedian(Queue<Integer> maxHeap, Queue<Integer> minHeap) {
    if (maxHeap.size() == minHeap.size()) return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
    return maxHeap.peek();
  }
}
