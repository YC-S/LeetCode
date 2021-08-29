package leetcode500.p26_sweep_line.plan1;

import java.util.Map;
import java.util.TreeMap;

public class P1094_CarPooling {
  public boolean carPooling(int[][] trips, int capacity) {
    Map<Integer, Integer> map = new TreeMap<>();
    for (int[] trip : trips) {
      map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
      map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
    }
    for (int val : map.values()) {
      capacity -= val;
      if (capacity < 0) return false;
    }
    return true;
  }
}
