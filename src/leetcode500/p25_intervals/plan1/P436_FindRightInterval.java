package leetcode500.p25_intervals.plan1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class P436_FindRightInterval {
  public int[] findRightInterval(int[][] intervals) {
    int[] res = new int[intervals.length];
    Map<int[], Integer> map = new HashMap<>();
    for (int i = 0; i < intervals.length; i++) {
      map.put(intervals[i], i);
    }
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    for (int i = 0; i < intervals.length; i++) {
      int[] interval = binarySearch(intervals, intervals[i][1], 0, intervals.length - 1);
      res[map.get(intervals[i])] = interval == null ? -1 : map.get(interval);
    }
    return res;
  }

  public int[] binarySearch(int[][] intervals, int target, int start, int end) {
    if (start >= end) {
      if (intervals[start][0] >= target) {
        return intervals[start];
      }
      return null;
    }
    int mid = (start + end) / 2;
    if (intervals[mid][0] < target) {
      return binarySearch(intervals, target, mid + 1, end);
    } else {
      return binarySearch(intervals, target, start, mid);
    }
  }
}
