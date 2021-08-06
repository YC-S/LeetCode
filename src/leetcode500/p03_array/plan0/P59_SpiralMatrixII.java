package leetcode500.p03_array.plan0;

public class P59_SpiralMatrixII {
  public int[][] generateMatrix(int n) {
    int[][] res = new int[n][n];
    int r1 = 0, r2 = n - 1, c1 = 0, c2 = n - 1, val = 1;
    while (r1 <= r2 && c1 <= c2) {
      for (int c = c1; c <= c2; c++) res[r1][c] = val++;
      r1++;
      for (int r = r1; r <= r2; r++) res[r][c2] = val++;
      c2--;
      for (int c = c2; c >= c1; c--) res[r2][c] = val++;
      r2--;
      for (int r = r2; r >= r1; r--) res[r][c1] = val++;
      c1++;
    }
    return res;
  }
}
