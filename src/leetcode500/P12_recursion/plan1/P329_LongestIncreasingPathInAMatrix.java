package leetcode500.P12_recursion.plan1;

public class P329_LongestIncreasingPathInAMatrix {
  private final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
  private int m, n;

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix.length == 0) return 0;
    m = matrix.length;
    n = matrix[0].length;
    int[][] cache = new int[m][n];
    int res = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        res = Math.max(res, dfs(matrix, i, j, cache));
      }
    }
    return res;
  }

  private int dfs(int[][] matrix, int i, int j, int[][] cache) {
    if (cache[i][j] != 0) return cache[i][j];
    for (int[] dir : dirs) {
      int x = i + dir[0], y = j + dir[1];
      if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j]) {
        cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
      }
    }
    return ++cache[i][j];
  }
}
