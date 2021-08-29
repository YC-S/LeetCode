package leetcode500.p26_sweep_line.plan1;

import java.util.Arrays;

public class P253_MeetingRoomsII {
  public int minMeetingRooms(int[][] intervals) {
    int n = intervals.length;
    int[] start = new int[n];
    int[] end = new int[n];
    for (int i = 0; i < n; i++) {
      start[i] = intervals[i][0];
      end[i] = intervals[i][1];
    }
    Arrays.sort(start);
    Arrays.sort(end);
    int room = 0, pre = 0; // pre is the index of end room
    for (int i = 0; i < n; i++) {
      if (start[i] < end[pre]) room++;
      else pre++;
    }
    return room;
  }
}
