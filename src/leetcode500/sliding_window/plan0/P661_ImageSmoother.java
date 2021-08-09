package leetcode500.sliding_window.plan0;

public class P661_ImageSmoother {
  public int[][] imageSmoother(int[][] img) {
    if (img == null || img.length == 0) return new int[0][0];
    int m = img.length, n = img[0].length;
    int[][] res = new int[m][n];
    int[][] moves =
        new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int sum = img[i][j];
        int count = 1;
        for (int[] move : moves) {
          int I = i + move[0];
          int J = j + move[1];
          if (I >= 0 && I < m && J >= 0 && J < n) {
            count++;
            sum += img[I][J];
          }
        }
        res[i][j] = sum / count;
      }
    }
    return res;
  }
}
