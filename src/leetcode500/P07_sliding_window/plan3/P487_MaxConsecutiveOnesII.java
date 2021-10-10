package leetcode500.P07_sliding_window.plan3;

public class P487_MaxConsecutiveOnesII {
  public int findMaxConsecutiveOnes(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int i = 0, j = 0, max = 0, countZero = 0;
    while (j < nums.length) {
      if (nums[j] == 1) {
        j++;
        max = Math.max(j - i, max);
      } else if (countZero < 1) {
        j++;
        max = Math.max(j - i, max);
        countZero++;
      } else if (nums[i++] == 0) {
        countZero--;
      }
    }
    return max;
  }
}
