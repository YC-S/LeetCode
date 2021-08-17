package leetcode500.P14_hybrid_data_structure.plan0;

public class P622_DesignCircularQueue {
  private final int capacity;
  private final int[] queue;
  private int startIndex;
  private int count;

  /** Initialize your data structure here. Set the size of the queue to be k. */
  public P622_DesignCircularQueue(int k) {
    this.capacity = k;
    this.queue = new int[capacity];
    this.startIndex = 0;
    this.count = 0;
  }

  /** Insert an element into the circular queue. Return true if the operation is successful. */
  public boolean enQueue(int value) {
    if (count == capacity) return false;
    queue[(startIndex + count) % capacity] = value;
    this.count++;
    return true;
  }

  /** Delete an element from the circular queue. Return true if the operation is successful. */
  public boolean deQueue() {
    if (count == 0) return false;
    this.startIndex = (this.startIndex + 1) % capacity;
    this.count--;
    return true;
  }

  /** Get the front item from the queue. */
  public int Front() {
    if (count == 0) return -1;
    return queue[startIndex];
  }

  /** Get the last item from the queue. */
  public int Rear() {
    if (count == 0) return -1;
    return queue[(startIndex + count - 1) % capacity];
  }

  /** Checks whether the circular queue is empty or not. */
  public boolean isEmpty() {
    return count == 0;
  }

  /** Checks whether the circular queue is full or not. */
  public boolean isFull() {
    return count == capacity;
  }
}
