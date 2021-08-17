package leetcode500.P14_hybrid_data_structure.plan0;

import java.util.ArrayDeque;
import java.util.Deque;

public class P1188_DesignBoundedBlockingQueue {
  Deque<Integer> deque;
  int cap;

  public P1188_DesignBoundedBlockingQueue(int capacity) {
    deque = new ArrayDeque<>(capacity);
    cap = capacity;
  }

  public synchronized void enqueue(int element) throws InterruptedException {
    while (deque.size() == cap) {
      wait();
    }
    deque.offerFirst(element);
    notifyAll();
  }

  public synchronized int dequeue() throws InterruptedException {
    while (deque.isEmpty()) {
      wait();
    }
    int last = deque.pollLast();
    notifyAll();
    return last;
  }

  public int size() {
    return deque.size();
  }
}
