package leetcode500.p32_bit_operation.plan1;

public class P268_MissingNumber {
  public int missingNumber(int[] nums) {
    int n = nums.length;
    int sum = (n) * (n + 1) / 2;
    for (int num : nums) {
      sum -= num;
    }
    return sum;
  }
}
