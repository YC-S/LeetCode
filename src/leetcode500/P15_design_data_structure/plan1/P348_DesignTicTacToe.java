package leetcode500.P15_design_data_structure.plan1;

public class P348_DesignTicTacToe {
  int[] rows;
  int[] cols;
  int diagonal;
  int antiDiagonal;

  public P348_DesignTicTacToe(int n) {
    rows = new int[n];
    cols = new int[n];
  }

  public int move(int row, int col, int player) {
    int currentPlayer = (player == 1) ? 1 : -1;
    // update currentPlayer in rows and cols arrays
    rows[row] += currentPlayer;
    cols[col] += currentPlayer;
    // update diagonal
    if (row == col) {
      diagonal += currentPlayer;
    }
    // update anti diagonal
    if (col == (cols.length - row - 1)) {
      antiDiagonal += currentPlayer;
    }
    int n = rows.length;
    // check if the current player wins
    if (Math.abs(rows[row]) == n
        || Math.abs(cols[col]) == n
        || Math.abs(diagonal) == n
        || Math.abs(antiDiagonal) == n) {
      return player;
    }
    // No one wins
    return 0;
  }
}
