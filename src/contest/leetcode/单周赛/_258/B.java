package contest.leetcode.单周赛._258;

import java.util.HashMap;
import java.util.Map;

public class B {
  public static void main(String[] args) {
    System.out.println(
        new B().interchangeableRectangles(new int[][] {{4, 8}, {3, 6}, {10, 20}, {15, 30}}));
    System.out.println(new B().interchangeableRectangles(new int[][] {{4, 5}, {7, 8}}));
  }

  public long interchangeableRectangles(int[][] rectangles) {
    double[] array = new double[rectangles.length];
    for (int i = 0; i < rectangles.length; i++) {
      array[i] = (double) rectangles[i][0] / (double) rectangles[i][1];
    }
    Map<Double, Long> map = new HashMap<>();
    for (double v : array) {
      map.put(v, map.getOrDefault(v, 0L) + 1);
    }
    long res = 0;
    for (Map.Entry<Double, Long> entry : map.entrySet()) {
      double key = entry.getKey();
      long val = entry.getValue();
      res += (val) * (val - 1) / 2;
    }
    return res;
  }
}
