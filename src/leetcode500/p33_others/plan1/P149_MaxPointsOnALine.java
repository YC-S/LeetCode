package leetcode500.p33_others.plan1;

import java.util.HashMap;
import java.util.Map;

public class P149_MaxPointsOnALine {
  private final Map<Double, Integer> map = new HashMap<>();
  private int ans = 0, horizon = 0, duplicate = 0;

  public int maxPoints(int[][] points) {
    int n = points.length;
    if (n < 3) return n;
    for (int i = 0; i < n - 1; i++) {
      int count = 1;
      map.clear();
      duplicate = 0;
      horizon = 1;
      for (int j = i + 1; j < n; j++) {
        count = add_lines(points[i], points[j], count);
        ans = Math.max(ans, count + duplicate);
      }
    }
    return ans;
  }

  private int add_lines(int[] p1, int[] p2, int count) {
    int x1 = p1[0], y1 = p1[1], x2 = p2[0], y2 = p2[1];
    if (x1 == x2 && y1 == y2) duplicate++;
    else if (y1 == y2) {
      horizon++;
      count = Math.max(count, horizon);
    } else {
      double slope = 1.0 * (x1 - x2) / (y1 - y2) + 0.0;
      map.put(slope, map.getOrDefault(slope, 1) + 1);
      count = Math.max(count, map.get(slope));
    }
    return count;
  }
}
