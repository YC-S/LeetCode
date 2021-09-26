package contest.leetcode.单周赛._260;

public class B {
  public static void main(String[] args) {
    System.out.println(new B().gridGame(new int[][] {{2, 5, 4}, {1, 5, 1}}));
  }

  public long gridGame(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int max = Integer.MIN_VALUE;
    int cur = 0;
    dfs(m, n, grid, max, 0, 0, cur);
    return max;
  }

  private void dfs(int m, int n, int[][] grid, int max, int i, int j, int cur) {
    if (i < 0 || j < 0 || i >= m || j >= n) {
      return;
    }
    if (i == m - 1 && j == n - 1) {
      max = Math.max(max, cur);
      return;
    }
    dfs(m, n, grid, max, i + 1, j, cur + grid[i][j]);
    dfs(m, n, grid, max, i, j + 1, cur + grid[i][j]);
  }
}
