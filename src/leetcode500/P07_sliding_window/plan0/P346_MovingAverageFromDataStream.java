package leetcode500.P07_sliding_window.plan0;

import java.util.LinkedList;
import java.util.Queue;

public class P346_MovingAverageFromDataStream {
  private final int size;
  private final Queue<Integer> queue;
  private double sum = 0;

  public P346_MovingAverageFromDataStream(int size) {
    this.size = size;
    this.queue = new LinkedList<>();
  }

  public double next(int val) {
    queue.offer(val);
    sum += val;
    if (queue.size() > size) {
      sum -= queue.poll();
    }
    return sum / queue.size();
  }
}
