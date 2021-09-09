package leetcode500.p02_binary_search.plan2;

public class P240_SearchA2DMatrixII {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) return false;
    int m = matrix.length, n = matrix[0].length;
    int row = matrix.length - 1;
    int col = 0;
    while (row >= 0 && col < n) {
      if (matrix[row][col] > target) {
        row--;
      } else if (matrix[row][col] < target) {
        col++;
      } else { // found it
        return true;
      }
    }

    return false;
  }
}
