package leetcode500.p32_bit_operation.plan1;

public class P136_SingleNumber {
  public int singleNumber(int[] nums) {
    int res = 0;
    for (int num : nums) {
      res ^= num;
    }
    return res;
  }
}
