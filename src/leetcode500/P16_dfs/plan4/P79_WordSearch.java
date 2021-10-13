package leetcode500.P16_dfs.plan4;

public class P79_WordSearch {
  public boolean exist(char[][] board, String word) {
    char[] array = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (dfs(board, array, 0, i, j)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, char[] array, int index, int row, int col) {
    if (index == array.length) {
      return true;
    }
    if (row < 0
        || row >= board.length
        || col < 0
        || col >= board[0].length
        || board[row][col] != array[index]) return false;
    board[row][col] ^= 256;
    boolean exist =
        dfs(board, array, index + 1, row - 1, col)
            || dfs(board, array, index + 1, row + 1, col)
            || dfs(board, array, index + 1, row, col - 1)
            || dfs(board, array, index + 1, row, col + 1);
    board[row][col] ^= 256;
    return exist;
  }
}
