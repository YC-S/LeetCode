package leetcode500.p03_array.plan5;

public class P303_RangeSumQuery {
  int[] nums;
  int[] prefixNums;

  public P303_RangeSumQuery(int[] nums) {
    this.nums = nums;
    int n = nums.length;
    prefixNums = new int[n];
    prefixNums[0] = nums[0];
    for (int i = 1; i < n; i++) {
      prefixNums[i] = prefixNums[i - 1] + nums[i];
    }
  }

  public int sumRange(int left, int right) {
    return left == 0 ? prefixNums[right] : prefixNums[right] - prefixNums[left - 1];
  }
}
