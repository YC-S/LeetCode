package leetcode500.p32_bit_operation.plan1;

public class P190_ReverseBits {
  public int reverseBits(int n) {
    int res = 0;
    int count = 31;
    while (n != 0) {
      int lsb = n & 1;
      n >>>= 1;
      res += (lsb <<= count);
      count--;
    }
    return res;
  }
}
