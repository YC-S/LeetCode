package leetcode500.P16_dfs.plan5;

public class P351_AndroidUnlockPatterns {
  /**
   * The general idea is DFS all the possible combinations from 1 to 9 and skip invalid moves along
   * the way. We can check invalid moves by using a skip table. e.g. If a move requires a jump and
   * the key that it is crossing is not visited, then the move is invalid. Furthermore, we can
   * utilize symmetry to reduce runtime, 1,3,7,9 are symmetric, 2,4,6,8 are also symmetric. Hence we
   * only calculate one among each group and multiply by 4.
   */
  public int numberOfPatterns(int m, int n) {
    // Skip array represents number to skip between two pairs
    int[][] skip = new int[10][10];
    skip[1][3] = skip[3][1] = 2;
    skip[1][7] = skip[7][1] = 4;
    skip[3][9] = skip[9][3] = 6;
    skip[7][9] = skip[9][7] = 8;
    skip[1][9] =
        skip[9][1] =
            skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
    boolean[] visited = new boolean[10];
    int result = 0;
    // DFS search each length from m to n
    for (int i = m; i <= n; ++i) {
      result += DFS(visited, skip, 1, i - 1) * 4; // 1, 3, 7, 9 are symmetric
      result += DFS(visited, skip, 2, i - 1) * 4; // 2, 4, 6, 8 are symmetric
      result += DFS(visited, skip, 5, i - 1); // 5
    }
    return result;
  }

  private int DFS(boolean[] visited, int[][] skip, int cur, int remain) {
    // cur: the current position
    // remain: the steps remaining
    if (remain < 0) return 0;
    if (remain == 0) return 1;
    visited[cur] = true;
    int result = 0;
    for (int i = 1; i <= 9; ++i) {
      // If vis[i] is not visited and (two numbers are adjacent or skip number is already visited)
      if (!visited[i] && (skip[cur][i] == 0 || (visited[skip[cur][i]]))) {
        result += DFS(visited, skip, i, remain - 1);
      }
    }
    visited[cur] = false;
    return result;
  }
}
