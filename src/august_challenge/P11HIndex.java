/*
 * Copyright (c) 2020. Yuanchen
 */

package august_challenge;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/12
 */
public class P11HIndex {

  public int hIndex(int[] citations) {
    int n = citations.length;
    int[] buckets = new int[n + 1];
    for (int c : citations) {
      if (c >= n) {
        buckets[n]++;
      } else {
        buckets[c]++;
      }
    }
    int count = 0;
    for (int i = n; i >= 0; i--) {
      count += buckets[i];
      if (count >= i) {
        return i;
      }
    }
    return 0;
  }
}
