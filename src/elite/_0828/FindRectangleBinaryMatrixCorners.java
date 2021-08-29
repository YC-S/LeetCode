package elite._0828;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindRectangleBinaryMatrixCorners {
  public static boolean isRectangle(int[][] matrix) {
    int rows = matrix.length;
    if (rows == 0) return false;
    int columns = matrix[0].length;
    Map<Integer, Set<Integer>> table = new HashMap<>();
    for (int[] ints : matrix) {
      for (int i = 0; i < columns - 1; i++) {
        for (int j = i + 1; j < columns; j++) {
          if (ints[i] == 1 && ints[j] == 1) {
            if (table.containsKey(i) && table.get(i).contains(j)) return true;
            if (table.containsKey(j) && table.get(j).contains(i)) return true;
            if (!table.containsKey(i)) {
              Set<Integer> tmp = new HashSet<>();
              tmp.add(j);
              table.put(i, tmp);
            } else {
              table.get(i).add(j);
            }
            if (!table.containsKey(j)) {
              Set<Integer> tmp = new HashSet<>();
              tmp.add(i);
              table.put(j, tmp);
            } else {
              table.get(j).add(i);
            }
          }
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] matrix = {{1, 0, 0, 1, 0}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 0, 1}};
    System.out.println(isRectangle(matrix));
  }
}
