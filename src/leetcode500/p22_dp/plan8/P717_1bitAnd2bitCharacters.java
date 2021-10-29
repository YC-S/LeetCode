package leetcode500.p22_dp.plan8;

public class P717_1bitAnd2bitCharacters {
  public boolean isOneBitCharacter(int[] bits) {
    int ones = 0;
    for (int i = bits.length - 2; i >= 0 && bits[i] != 0; i--) {
      ones++;
    }
    return ones % 2 == 0;
  }
}
