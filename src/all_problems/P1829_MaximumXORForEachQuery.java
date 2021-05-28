package all_problems;

public class P1829_MaximumXORForEachQuery {
  public int[] getMaximumXor(int[] nums, int maximumBit) {
    int n = nums.length, i = n - 1, mx = (1 << maximumBit) - 1, xor = 0;
    int[] ans = new int[n];
    for (int num : nums) {
      xor ^= num;
      ans[i--] = xor ^ mx;
    }
    return ans;
  }
}
