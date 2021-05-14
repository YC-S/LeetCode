package algoexpert;

import java.util.ArrayList;
import java.util.List;

public class SquareOfZeroes {
  public static boolean squareOfZeroes(List<List<Integer>> matrix) {
    List<List<InfoMatrixItem>> infoMatrix = preComputedNumOfZeroes(matrix);
    int n = matrix.size();
    for (int topRow = 0; topRow < n; topRow++) {
      for (int leftCol = 0; leftCol < n; leftCol++) {
        int squareLength = 2;
        while (squareLength <= n - leftCol && squareLength <= n - topRow) {
          int bottomRow = topRow + squareLength - 1;
          int rightCol = leftCol + squareLength - 1;
          if (isSquareOfZeroes(infoMatrix, topRow, leftCol, bottomRow, rightCol)) return true;
          squareLength++;
        }
      }
    }
    return false;
  }

  public static boolean isSquareOfZeroes(
      List<List<InfoMatrixItem>> infoMatrix, int r1, int c1, int r2, int c2) {
    int squareLength = c2 - c1 + 1;
    boolean hasTopBorder = infoMatrix.get(r1).get(c1).numZeroesRight >= squareLength;
    boolean hasLeftBorder = infoMatrix.get(r1).get(c1).numZeroesBelow >= squareLength;
    boolean hasBottomBorder = infoMatrix.get(r2).get(c1).numZeroesRight >= squareLength;
    boolean hasRightBorder = infoMatrix.get(r1).get(c2).numZeroesBelow >= squareLength;
    return hasTopBorder && hasLeftBorder && hasBottomBorder && hasRightBorder;
  }

  public static List<List<InfoMatrixItem>> preComputedNumOfZeroes(List<List<Integer>> matrix) {
    List<List<InfoMatrixItem>> infoMatrix = new ArrayList<>();
    for (List<Integer> integers : matrix) {
      List<InfoMatrixItem> inner = new ArrayList<>();
      for (Integer integer : integers) {
        int numZeroes = integer == 0 ? 1 : 0;
        inner.add(new InfoMatrixItem(numZeroes, numZeroes));
      }
      infoMatrix.add(inner);
    }

    int lastIdx = matrix.size() - 1;
    for (int row = lastIdx; row >= 0; row--) {
      for (int col = lastIdx; col >= 0; col--) {
        if (matrix.get(row).get(col) == 1) continue;
        if (row < lastIdx) {
          infoMatrix.get(row).get(col).numZeroesBelow +=
              infoMatrix.get(row + 1).get(col).numZeroesBelow;
        }
        if (col < lastIdx) {
          infoMatrix.get(row).get(col).numZeroesRight +=
              infoMatrix.get(row).get(col + 1).numZeroesRight;
        }
      }
    }
    return infoMatrix;
  }

  static class InfoMatrixItem {
    public int numZeroesBelow;
    public int numZeroesRight;

    public InfoMatrixItem(int numZeroesBelow, int numZeroesRight) {
      this.numZeroesBelow = numZeroesBelow;
      this.numZeroesRight = numZeroesRight;
    }
  }
}
