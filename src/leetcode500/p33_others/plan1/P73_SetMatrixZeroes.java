package leetcode500.p33_others.plan1;

import java.util.HashSet;
import java.util.Set;

public class P73_SetMatrixZeroes {
  public void setZeroes(int[][] matrix) {
    Set<Integer> colSet = new HashSet<Integer>();
    Set<Integer> rowSet = new HashSet<Integer>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          colSet.add(j);
          rowSet.add(i);
        }
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      boolean hasRow = rowSet.contains(i);
      for (int j = 0; j < matrix[0].length; j++) {
        if (hasRow || colSet.contains(j)) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}
