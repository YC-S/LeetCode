package leetcode500.p17_graph_traversal.plan2;

public class P130_SurroundedRegions {

  public void solve(char[][] board) {
    if (board == null || board.length == 0) return;

    int m = board.length, n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) { // check border
          if (board[i][j] == 'O') dfs(board, m, n, i, j);
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == '*') board[i][j] = 'O';
        else board[i][j] = 'X';
      }
    }
  }

  public void dfs(char[][] board, int m, int n, int i, int j) {
    if (i < 0 || i >= m || j < 0 || j >= n) return;
    if (board[i][j] == 'X' || board[i][j] == '*') return; // X or has been visited
    board[i][j] = '*'; // cannot be flipped
    dfs(board, m, n, i - 1, j);
    dfs(board, m, n, i + 1, j);
    dfs(board, m, n, i, j - 1);
    dfs(board, m, n, i, j + 1);
  }
}
