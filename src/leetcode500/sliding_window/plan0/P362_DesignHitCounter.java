package leetcode500.sliding_window.plan0;

import java.util.LinkedList;
import java.util.Queue;

public class P362_DesignHitCounter {
  Queue<Integer> q;

  public P362_DesignHitCounter() {
    q = new LinkedList<>();
  }

  public void hit(int timestamp) {
    q.add(timestamp);
  }

  public int getHits(int timestamp) {
    while (!q.isEmpty() && (timestamp - 300) >= q.peek()) {
      q.poll();
    }
    return q.size();
  }
}
