package leetcode500.p25_intervals.plan1;

import java.util.Arrays;
import java.util.Comparator;

public class P435_NonOverlappingIntervals {
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals == null || intervals.length == 0) return 0;
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
    int res = 0;
    int prev = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= prev) {
        prev = intervals[i][1];
      } else {
        res++;
      }
    }
    return res;
  }
}
