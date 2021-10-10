package leetcode500.P07_sliding_window.plan3;

public class P1004_MaxConsecutiveOnesIII {
  public int longestOnes(int[] nums, int k) {
    if (nums == null || nums.length == 0) return 0;
    int i = 0, j = 0, countZero = 0, max = 0;
    while (j < nums.length) {
      if (nums[j] == 1) {
        j++;
        max = Math.max(max, j - i);
      } else if (countZero < k) {
        j++;
        max = Math.max(max, j - i);
        countZero++;
      } else if (nums[i++] == 0) {
        countZero--;
      }
    }
    return max;
  }
}
