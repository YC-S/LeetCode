package leetcode500.p32_bit_operation.plan1;

public class P191_NumberOf1Bits {
  public int hammingWeight(int n) {
    int res = 0;
    while (n != 0) {
      res += (n & 1);
      n >>>= 1;
    }
    return res;
  }
}
