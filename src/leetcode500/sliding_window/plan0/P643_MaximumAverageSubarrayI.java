package leetcode500.sliding_window.plan0;

public class P643_MaximumAverageSubarrayI {
  public double findMaxAverage(int[] nums, int k) {
    double sum = 0;
    double cur = 0;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
      cur += nums[i];
    }
    for (int i = 1; i < nums.length - k + 1; i++) {
      cur = cur - nums[i - 1] + nums[i + k - 1];
      sum = Math.max(sum, cur);
    }
    return sum / k;
  }
}
