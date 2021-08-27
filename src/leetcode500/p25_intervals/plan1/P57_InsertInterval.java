package leetcode500.p25_intervals.plan1;

import java.util.LinkedList;

public class P57_InsertInterval {
  public P57_InsertInterval() {}

  public int[][] insert(int[][] intervals, int[] newInterval) {
    int newStart = newInterval[0], newEnd = newInterval[1];
    int idx = 0, n = intervals.length;
    LinkedList<int[]> output = new LinkedList<>();
    while (idx < n && newStart > intervals[idx][0]) {
      output.add(intervals[idx++]);
    }
    int[] interval = new int[2];
    if (output.isEmpty() || output.getLast()[1] < newStart) {
      output.add(newInterval);
    } else {
      interval = output.removeLast();
      interval[1] = Math.max(interval[1], newEnd);
      output.add(interval);
    }
    while (idx < n) {
      interval = intervals[idx++];
      int start = interval[0], end = interval[1];
      if (output.getLast()[1] < start) {
        output.add(interval);
      } else {
        interval = output.removeLast();
        interval[1] = Math.max(interval[1], end);
        output.add(interval);
      }
    }
    return output.toArray(new int[output.size()][2]);
  }
}
