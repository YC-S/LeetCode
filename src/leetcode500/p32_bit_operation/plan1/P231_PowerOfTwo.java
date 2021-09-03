package leetcode500.p32_bit_operation.plan1;

public class P231_PowerOfTwo {
  public boolean isPowerOfTwo(int n) {
    if (n == 0) return false;
    while ((n & 1) == 0) {
      n >>= 1;
    }
    return n == 1;
  }
}
