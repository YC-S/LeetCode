package leetcode500.P07_sliding_window.plan0;

import java.util.Collections;
import java.util.PriorityQueue;

public class P295_FindMedianFromDataStream {
  PriorityQueue<Integer> min = new PriorityQueue<>();
  PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

  public void addNum(int num) {
    max.offer(num);
    min.offer(max.poll());
    if (max.size() < min.size()) {
      max.offer(min.poll());
    }
  }

  public double findMedian() {
    if (max.size() == min.size()) return (max.peek() + min.peek()) / 2.0;
    else return max.peek();
  }
}
