package leetcode500.p32_bit_operation.plan1;

public class P393_UTF8Validation {
  public boolean validUtf8(int[] data) {
    int numberOfBytesToProcess = 0;
    int mask1 = 1 << 7;
    int mask2 = 1 << 6;
    for (int i : data) {
      if (numberOfBytesToProcess == 0) {
        int mask = 1 << 7;
        while ((mask & i) != 0) {
          numberOfBytesToProcess++;
          mask = mask >> 1;
        }
        if (numberOfBytesToProcess == 0) {
          continue;
        }
        if (numberOfBytesToProcess > 4 || numberOfBytesToProcess == 1) {
          return false;
        }
      } else {
        if (!((i & mask1) != 0 && (mask2 & i) == 0)) {
          return false;
        }
      }
      numberOfBytesToProcess--;
    }
    return numberOfBytesToProcess == 0;
  }
}
