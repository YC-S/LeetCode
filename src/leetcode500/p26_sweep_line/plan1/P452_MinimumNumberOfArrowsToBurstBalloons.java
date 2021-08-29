package leetcode500.p26_sweep_line.plan1;

import java.util.Arrays;
import java.util.Comparator;

public class P452_MinimumNumberOfArrowsToBurstBalloons {
  public int findMinArrowShots(int[][] points) {
    if (points.length == 0) return 0;
    Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
    int arrows = 1;
    int start, end, prevEnd = points[0][1];
    for (int[] point : points) {
      start = point[0];
      end = point[1];
      if (prevEnd < start) {
        arrows++;
        prevEnd = end;
      }
    }
    return arrows;
  }
}
