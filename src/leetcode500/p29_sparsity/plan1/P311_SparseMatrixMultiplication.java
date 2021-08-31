package leetcode500.p29_sparsity.plan1;

import java.util.Arrays;

public class P311_SparseMatrixMultiplication {
  public static int[][] multiply(int[][] mat1, int[][] mat2) {
    int len1 = mat1.length, len2 = mat2[0].length;

    int[][] ans = new int[len1][len2];
    for (int i = 0; i < len1; i++) {
      for (int j = 0; j < len2; j++) {

        int sum = 0, p = 0, q = 0;
        while (p < mat1[0].length && q < mat2.length) {
          sum += mat1[i][p++] * mat2[q++][j];
        }

        ans[i][j] = sum;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] mat1 = new int[][] {{1, -5}};
    int[][] mat2 = new int[][] {{12}, {-1}};
    int[][] res = multiply(mat1, mat2);
    for (int[] re : res) {
      System.out.println(Arrays.toString(re));
    }
  }
}
