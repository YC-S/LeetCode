package leetcode500.P14_hybrid_data_structure.plan1;

import java.util.ArrayDeque;
import java.util.Deque;

public class P232_ImplementQueueUsingStacks {
  Deque<Integer> queue;

  /** Initialize your data structure here. */
  public P232_ImplementQueueUsingStacks() {
    queue = new ArrayDeque<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    Deque<Integer> temp = new ArrayDeque<Integer>();
    while (!queue.isEmpty()) {
      temp.offerFirst(queue.pollFirst());
    }
    queue.offerFirst(x);
    while (!temp.isEmpty()) {
      queue.offerFirst(temp.pollFirst());
    }
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    return queue.pollFirst();
  }

  /** Get the front element. */
  public int peek() {
    return queue.peekFirst();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return queue.isEmpty();
  }
}
