package leetcode500.P07_sliding_window.plan3;

public class P485_MaxConsecutiveOnes {
  public int findMaxConsecutiveOnes(int[] nums) {
    int cur = 0, max = 0;
    for (int num : nums) {
      if (num == 1) {
        cur++;
        max = Math.max(cur, max);
      } else {
        cur = 0;
      }
    }
    return max;
  }
}
