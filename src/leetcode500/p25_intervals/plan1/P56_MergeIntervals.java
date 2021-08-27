package leetcode500.p25_intervals.plan1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P56_MergeIntervals {
  public int[][] merge(int[][] intervals) {
    if (intervals.length <= 1) return intervals;
    Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

    List<int[]> res = new ArrayList<>();
    int[] newInterval = intervals[0];
    res.add(newInterval);
    for (int[] interval : intervals) {
      if (interval[0] <= newInterval[1]) {
        newInterval[1] = Math.max(newInterval[1], interval[1]);
      } else {
        newInterval = interval;
        res.add(newInterval);
      }
    }
    return res.toArray(new int[res.size()][]);
  }
}
