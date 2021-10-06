package leetcode500.p03_array.plan4;

import java.util.ArrayDeque;
import java.util.Deque;

public class P456_132Pattern {
  public boolean find132Pattern(int[] nums) {
    if (nums.length < 3) return false;
    Deque<Integer> stack = new ArrayDeque<>();
    int[] min = new int[nums.length];
    min[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      min[i] = Math.min(nums[i], min[i - 1]);
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] > min[i]) {
        while (!stack.isEmpty() && stack.peekFirst() <= min[i]) {
          stack.pollFirst();
        }
        if (!stack.isEmpty() && stack.peekFirst() < nums[i]) return true;
        stack.offerFirst(nums[i]);
      }
    }
    return false;
  }
}
