package all_problems;

import java.util.Arrays;

public class P1820_MaximumNumberOfAcceptedInvitations {
  public int maximumInvitations(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int[] match = new int[n];
    Arrays.fill(match, -1);
    int res = 0;

    for (int i = 0; i < m; i++) {
      boolean[] fixedMatch = new boolean[n];
      if (dfs(i, grid, match, fixedMatch)) res++;
    }
    return res;
  }

  private boolean dfs(int i, int[][] grid, int[] match, boolean[] fixedMatch) {
    int n = grid[0].length;
    for (int j = 0; j < n; j++) {
      if (grid[i][j] == 0 || fixedMatch[j]) continue;
      fixedMatch[j] = true;
      if (match[j] == -1 || dfs(match[j], grid, match, fixedMatch)) {
        match[j] = i;
        return true;
      }
    }
    return false;
  }
}
