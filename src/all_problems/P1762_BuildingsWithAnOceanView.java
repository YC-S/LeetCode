package all_problems;

import java.util.ArrayList;
import java.util.List;

public class P1762_BuildingsWithAnOceanView {
  public int[] findBuildings(int[] heights) {
    if (heights == null || heights.length == 0) return new int[] {};
    List<Integer> list = new ArrayList<>();
    list.add(heights.length - 1);
    int min = heights[heights.length - 1];
    for (int i = heights.length - 2; i >= 0; i--) {
      if (heights[i] > min) {
        list.add(0, i);
        min = heights[i];
      }
    }
    return list.stream().mapToInt(i -> i).toArray();
  }
}
