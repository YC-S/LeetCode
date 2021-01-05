/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_june;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/18
 */
public class P18HIndexII {

  public int hIndex(int[] citations) {
    int len = citations.length;
    int lo = 0, hi = len - 1;
    while (lo <= hi) {
      int med = (hi + lo) / 2;
      if (citations[med] == len - med) {
        return len - med;
      } else if (citations[med] < len - med) {
        lo = med + 1;
      } else {
        // (citations[med] > len-med), med qualified as a hIndex,
        // but we have to continue to search for a higher one.
        hi = med - 1;
      }
    }
    return len - lo;
  }
}
