/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_june;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/10
 */
public class P10SearchInsertPosition {

  public int searchInsert(int[] A, int target) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int start = 0, end = A.length - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (A[mid] == target) {
        return mid;
      } else if (A[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }

    if (A[start] >= target) {
      return start;
    } else if (A[end] >= target) {
      return end;
    } else {
      return end + 1;
    }
  }
}
