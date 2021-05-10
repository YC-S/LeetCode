package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class MinimumAreaRectangle {
  public int minimumAreaRectangle(int[][] points) {
    // Write your code here.
    HashMap<Integer, int[]> columns = initializeColumns(points);
    int minimumAreaFound = Integer.MAX_VALUE;
    HashMap<String, Integer> edgesParallelToYAxis = new HashMap<>();
    ArrayList<Integer> sortedColumns = new ArrayList<>(columns.keySet());
    Collections.sort(sortedColumns);
    for (Integer x : sortedColumns) {
      int[] yValuesInCurrentColumn = columns.get(x);
      Arrays.sort(yValuesInCurrentColumn);
      for (int currentIdx = 0; currentIdx < yValuesInCurrentColumn.length; currentIdx++) {
        int y2 = yValuesInCurrentColumn[currentIdx];
        for (int previousIdx = 0; previousIdx < currentIdx; previousIdx++) {
          int y1 = yValuesInCurrentColumn[previousIdx];
          String pointString = y1 + ":" + y2;
          if (edgesParallelToYAxis.containsKey(pointString)) {
            int currentArea = (x - edgesParallelToYAxis.get(pointString)) * (y2 - y1);
            minimumAreaFound = Math.min(minimumAreaFound, currentArea);
          }
          edgesParallelToYAxis.put(pointString, x);
        }
      }
    }
    return (minimumAreaFound != Integer.MAX_VALUE) ? minimumAreaFound : 0;
  }

  public HashMap<Integer, int[]> initializeColumns(int[][] points) {
    HashMap<Integer, int[]> columns = new HashMap<>();
    for (int[] point : points) {
      int x = point[0];
      int y = point[1];
      if (!columns.containsKey(x)) {
        columns.put(x, new int[] {});
      }
      int[] column = columns.get(x);
      int[] newColumn = new int[column.length + 1];
      System.arraycopy(column, 0, newColumn, 0, column.length);
      newColumn[column.length] = y;
      columns.put(x, newColumn);
    }
    return columns;
  }
}
