package laicode.cross_trainingIII;

public class LargestSquareOfMatches {
  public int largestSquareOfMatches(int[][] matrix) {
    int N = matrix.length;
    int M = matrix[0].length;
    if (N == 0 || M == 0) return 0;
    int res = 0;
    int[][] down = new int[N + 1][M + 1];
    int[][] right = new int[N + 1][M + 1];
    for (int i = N - 1; i >= 0; i--) {
      for (int j = M - 1; j >= 0; j--) {
        int curNum = matrix[i][j];
        if (hasRight(curNum)) right[i][j] = right[i][j + 1] + 1;
        if (hasDown(curNum)) down[i][j] = down[i + 1][j] + 1;
        if (hasBoth(curNum)) {
          for (int maxLength = Math.min(down[i][j], right[i][j]); maxLength >= 1; maxLength--) {
            if (right[i + maxLength][j] >= maxLength && down[i][j + maxLength] >= maxLength) {
              res = Math.max(res, maxLength);
            }
          }
        }
      }
    }
    return res;
  }

  private boolean hasRight(int num) {
    return num == 3 || num == 1;
  }

  private boolean hasDown(int num) {
    return num == 2 || num == 3;
  }

  private boolean hasBoth(int num) {
    return num == 3;
  }
}
