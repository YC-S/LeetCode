package leetcode500.P14_hybrid_data_structure.plan2;

import java.util.Collections;
import java.util.PriorityQueue;

public class P295_FindMedianFromDataStream {
  PriorityQueue<Integer> min;
  PriorityQueue<Integer> max;

  public P295_FindMedianFromDataStream() {
    min = new PriorityQueue<>();
    max = new PriorityQueue<>(Collections.reverseOrder());
  }

  public void addNum(int num) {
    max.offer(num);
    min.offer(max.poll());
    if (max.size() < min.size()) max.offer(min.poll());
  }

  public double findMedian() {
    if (max.size() == min.size()) return (max.peek() + min.peek()) / 2.0;
    else return max.peek();
  }
}
