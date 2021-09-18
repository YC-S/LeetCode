package leetcode500.P15_design_data_structure.plan2;

import java.util.Arrays;

public class P158_ReadNCharactersGivenRead4II extends Reader4 {
  private final char[] buf4;
  private int buf4Idx;
  private int prevNumRead;

  public P158_ReadNCharactersGivenRead4II() {
    buf4 = new char[4];
    buf4Idx = 0;
    prevNumRead = 0;
  }

  /**
   * @param buf Destination buffer
   * @param n Number of characters to read
   * @return The number of actual characters read
   */
  public int read(char[] buf, int n) {
    int total = 0;
    int bufIdx = 0;

    // if there's already some carry over from before
    if (buf4Idx > 0) {
      while (buf4Idx < prevNumRead && total < n) {
        buf[bufIdx++] = buf4[buf4Idx++];
        total++;
      }
    }

    // continue reading if we haven't yet read all the required number of chars
    while (total < n) {
      Arrays.fill(buf4, '\u0000');
      buf4Idx = 0;
      prevNumRead = 0;

      int numRead = read4(buf4);
      if (numRead == 0) {
        break;
      }

      while (buf4Idx < numRead && total < n) {
        buf[bufIdx++] = buf4[buf4Idx++];
        total++;
      }

      prevNumRead = numRead;
    }

    return total;
  }
}
