package company.linkedin;

import java.util.LinkedList;
import java.util.Queue;

public class P362_HitCounter {
  Queue<Integer> queue;

  public P362_HitCounter() {
    queue = new LinkedList<>();
  }

  public void hit(int timestamp) {
    queue.add(timestamp);
  }

  public int getHits(int timestamp) {
    while (!queue.isEmpty() && timestamp >= queue.peek() + 300) {
      queue.poll();
    }
    return queue.size();
  }
}
