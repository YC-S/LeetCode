package leetcode500.p32_bit_operation.plan1;

public class P477_TotalHammingDistance {
  public int totalHammingDistance(int[] nums) {
    int res = 0, n = nums.length;
    for (int i = 0; i < 32; i++) {
      int count1 = 0;
      for (int num : nums) {
        count1 += (num >> i) & 1;
      }
      res += count1 * (n - count1);
    }
    return res;
  }
}
