package leetcode500.sliding_window.plan0;

import java.util.ArrayDeque;
import java.util.Deque;

public class P239_SlidingWindowMaximum {
  // 1. Use a deque to store the indexes and make sure head has the largest number
  // 2. For each incoming element, we first check whether it's bigger than the nums[last element] of
  // dq.
  //    If so, continue to remove nums[last element] of dq
  // 3. Check each head element to see if they are >= (end - k + 1) range. If not, remove head
  // 4. If end + 1 >= k, we update the result using nums[deque.peekFirst()] as head is always the
  // big number's index
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0) return new int[0];
    Deque<Integer> deque = new ArrayDeque<>();
    int index = 0;
    int[] res = new int[nums.length - k + 1];
    for (int i = 0; i < nums.length; i++) {
      int cur = nums[i];
      while (!deque.isEmpty() && nums[deque.peekLast()] < cur) deque.pollLast();
      while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) deque.pollFirst();
      deque.offerLast(i);
      if (i + 1 >= k) {
        res[index++] = nums[deque.peekFirst()];
      }
    }
    return res;
  }
}
