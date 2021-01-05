/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_july;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/12
 */
public class P12ReverseBits {

  public int reverseBits(int n) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      result += n & 1;
      n >>>= 1; // CATCH: must do unsigned shift
      if (i < 31) // CATCH: for last digit, don't shift!
      {
        result <<= 1;
      }
    }
    return result;
  }
}
