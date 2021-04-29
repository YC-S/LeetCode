package algoexpert;

public class MaximumSumSubmatrix {
  public int maximumSumSubmatrix(int[][] matrix, int size) {
    int[][] sums = createSumMatrix(matrix);
    int maxSubMatrixSum = Integer.MIN_VALUE;
    for (int row = size - 1; row < matrix.length; row++) {
      for (int col = size - 1; col < matrix[row].length; col++) {
        int total = sums[row][col];
        boolean touchesTopBorder = (row - size < 0);
        if (!touchesTopBorder) {
          total -= sums[row - size][col];
        }
        boolean touchesLeftBorder = (col - size < 0);
        if (!touchesLeftBorder) {
          total -= sums[row][col - size];
        }
        boolean touchesTopOrLeftBorder = (touchesTopBorder || touchesLeftBorder);
        if (!touchesTopOrLeftBorder) {
          total += sums[row - size][col - size];
        }
        maxSubMatrixSum = Math.max(maxSubMatrixSum, total);
      }
    }
    return maxSubMatrixSum;
  }

  public int[][] createSumMatrix(int[][] matrix) {
    int[][] sums = new int[matrix.length][matrix[0].length];
    sums[0][0] = matrix[0][0];
    for (int idx = 1; idx < matrix[0].length; idx++) {
      sums[0][idx] = sums[0][idx - 1] + matrix[0][idx];
    }
    for (int idx = 1; idx < matrix.length; idx++) {
      sums[idx][0] = sums[idx - 1][0] + matrix[idx][0];
    }
    for (int row = 1; row < matrix.length; row++) {
      for (int col = 1; col < matrix[0].length; col++) {
        sums[row][col] =
            sums[row - 1][col] + sums[row][col - 1] - sums[row - 1][col - 1] + matrix[row][col];
      }
    }
    return sums;
  }
}
