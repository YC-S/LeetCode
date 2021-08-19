package leetcode500.p17_graph_traversal.plan1;

public class P695_MaxAreaOfIsland {
  public int maxAreaOfIsland(int[][] grid) {
    int res = 0;
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] seen = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        res = Math.max(res, getArea(grid, i, j, m, n, seen));
      }
    }
    return res;
  }

  private int getArea(int[][] grid, int i, int j, int m, int n, boolean[][] seen) {
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || seen[i][j]) return 0;
    seen[i][j] = true;
    return (1
        + getArea(grid, i - 1, j, m, n, seen)
        + getArea(grid, i + 1, j, m, n, seen)
        + getArea(grid, i, j - 1, m, n, seen)
        + getArea(grid, i, j + 1, m, n, seen));
  }
}
