package leetcode500.p17_graph_traversal.plan2;

import java.util.ArrayList;
import java.util.List;

public class P417_PacificAtlanticWaterFlow {
  private final int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

  public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    int m = matrix.length;
    if (matrix.length == 0) return new ArrayList<>();
    int n = matrix[0].length;
    boolean[][] seenPacific = new boolean[m][n];
    boolean[][] seenAlantic = new boolean[m][n];

    // horizontally
    for (int c = 0; c < n; c++) {
      // top for pacifics
      dfs(0, c, seenPacific, matrix);
      // down for alantics
      dfs(m - 1, c, seenAlantic, matrix);
    }

    // vertically
    for (int r = 0; r < m; r++) {
      // left for pacifics
      dfs(r, 0, seenPacific, matrix);
      // right for alantics
      dfs(r, n - 1, seenAlantic, matrix);
    }
    List<List<Integer>> res = new ArrayList<>();

    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (seenPacific[r][c] && seenAlantic[r][c]) {
          List<Integer> temp = new ArrayList<>();
          temp.add(r);
          temp.add(c);
          res.add(temp);
        }
      }
    }

    return res;
  }

  private void dfs(int r, int c, boolean[][] seen, int[][] matrix) {
    if (seen[r][c]) return;
    seen[r][c] = true;

    for (int[] dir : dirs) {
      int newR = dir[0] + r, newC = dir[1] + c;
      if (isValid(newR, newC, seen.length, seen[0].length)) {
        if (matrix[newR][newC] >= matrix[r][c]) dfs(newR, newC, seen, matrix);
      }
    }
  }

  private boolean isValid(int r, int c, int m, int n) {
    return r >= 0 && r < m && c >= 0 && c < n;
  }
}
