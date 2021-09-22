package leetcode500.p24_dp_matrix.plan2;

public class P363_MaxSumOfRectangleNoLargerThanK {
  public int maxSumSubmatrix(int[][] matrix, int k) {
    int rows = matrix.length;
    int columns = matrix[0].length;
    int res = Integer.MIN_VALUE; // Serves as a smallest initial number for subsequent comparison.

    // Compress a 2D array into all possible sum[] for further search.
    // To compress columns, it has to be brute force
    for (int left = 0; left < columns; left++) {
      int[] sum = new int[rows];
      for (int right = left; right < columns; right++) {
        for (int i = 0; i < rows; i++) {
          sum[i] += matrix[i][right];
        }
        int max = maxSumRange(sum, k);
        if (max == k) return k;

        res = Math.max(res, max);
      }
    }
    return res;
  }

  // Brute Force. Given an array to find the max subarray sum.
  // It can be improved by TreeSet.
  public int maxSumRange(int[] sum, int k) {
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < sum.length; i++) {
      int cur = 0;
      for (int j = i; j < sum.length; j++) {
        cur += sum[j];
        // It is necessary, any result larger than k will be discarded.
        if (cur <= k) max = Math.max(max, cur);
      }
    }

    return max;
  }
}
