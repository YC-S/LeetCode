package leetcode500.p32_bit_operation.plan1;

public class P461_HammingDistance {
  public int hammingDistance(int x, int y) {
    int res = 0;
    while (x != 0 || y != 0) {
      res += ((x & 1) ^ (y & 1));
      x >>= 1;
      y >>= 1;
    }
    return res;
  }
}
