package leetcode500.p03_array.plan0;

public class P48_RotateImage {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    int round = n / 2;
    for (int level = 0; level < round; level++) {
      int left = level;
      int right = n - 2 - left;
      for (int i = left; i <= right; i++) {
        int tmp = matrix[left][i];
        matrix[left][i] = matrix[n - i - 1][left];
        matrix[n - i - 1][left] = matrix[n - left - 1][n - i - 1];
        matrix[n - left - 1][n - i - 1] = matrix[i][n - left - 1];
        matrix[i][n - left - 1] = tmp;
      }
    }
  }
}
