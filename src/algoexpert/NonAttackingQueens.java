package algoexpert;

public class NonAttackingQueens {
  public int nonAttackingQueens(int n) {
    // Write your code here.
    int[] columnPlacements = new int[n];
    return getNumberOfNonAttackingQueenPlacements(0, columnPlacements, n);
  }

  public int getNumberOfNonAttackingQueenPlacements(
      int row, int[] columnPlacements, int boardSize) {
    if (row == boardSize) return 1;
    int validPlacements = 0;
    for (int col = 0; col < boardSize; col++) {
      if (isNonAttackingPlacement(row, col, columnPlacements)) {
        columnPlacements[row] = col;
        validPlacements +=
            getNumberOfNonAttackingQueenPlacements(row + 1, columnPlacements, boardSize);
      }
    }
    return validPlacements;
  }

  public boolean isNonAttackingPlacement(int row, int col, int[] columnPlacements) {
    for (int previousRow = 0; previousRow < row; previousRow++) {
      int columnToCheck = columnPlacements[previousRow];
      boolean sameColumn = (columnToCheck == col);
      boolean onDiagonal = Math.abs(columnToCheck - col) == (row - previousRow);
      if (sameColumn || onDiagonal) return false;
    }
    return true;
  }
}
