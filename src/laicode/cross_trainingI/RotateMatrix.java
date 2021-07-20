package laicode.cross_trainingI;

import java.util.Arrays;

public class RotateMatrix {
  public static void rotate(int[][] matrix) {
    int n = matrix.length;
    if (n <= 1) return;
    int round = n / 2;
    for (int level = 0; level < round; level++) {
      int left = level;
      int right = n - 2 - level;
      for (int i = left; i <= right; i++) {
        int tmp = matrix[left][i];
        matrix[left][i] = matrix[n - i - 1][left];
        matrix[n - i - 1][left] = matrix[n - 1 - left][n - i - 1];
        matrix[n - 1 - left][n - i - 1] = matrix[i][n - 1 - left];
        matrix[i][n - left - 1] = tmp;
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][] {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
    rotate(matrix);
    for (int[] array : matrix) {
      System.out.println(Arrays.toString(array));
    }
  }
}
