package algoexpert;

import java.util.ArrayList;

public class SolveSudoku {
  public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
    solvePartialSudoku(0, 0, board);
    return board;
  }

  public boolean solvePartialSudoku(int row, int col, ArrayList<ArrayList<Integer>> board) {
    int currentRow = row;
    int currentCol = col;
    if (currentCol == board.get(currentRow).size()) {
      currentRow += 1;
      currentCol = 0;
      if (currentRow == board.size()) {
        return true;
      }
    }
    if (board.get(currentRow).get(currentCol) == 0) {
      return tryDigitsAtPosition(currentRow, currentCol, board);
    }
    return solvePartialSudoku(currentRow, currentCol + 1, board);
  }

  public boolean tryDigitsAtPosition(int row, int col, ArrayList<ArrayList<Integer>> board) {
    for (int digit = 1; digit < 10; digit++) {
      if (isValidAtPosition(digit, row, col, board)) {
        board.get(row).set(col, digit);
        if (solvePartialSudoku(row, col + 1, board)) {
          return true;
        }
      }
    }
    board.get(row).set(col, 0);
    return false;
  }

  public boolean isValidAtPosition(
      int value, int row, int col, ArrayList<ArrayList<Integer>> board) {
    boolean rowIsValid = !board.get(row).contains(value);
    boolean columnIsValid = true;
    for (ArrayList<Integer> integers : board) {
      if (integers.get(col) == value) {
        columnIsValid = false;
        break;
      }
    }
    if (!rowIsValid || !columnIsValid) {
      return false;
    }
    int subgridRowStart = (row / 3) * 3;
    int subgridColStart = (col / 3) * 3;
    for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
      for (int colIdx = 0; colIdx < 3; colIdx++) {
        int rowToCheck = subgridRowStart + rowIdx;
        int colToCheck = subgridColStart + colIdx;
        int existingValue = board.get(rowToCheck).get(colToCheck);
        if (existingValue == value) {
          return false;
        }
      }
    }
    return true;
  }
}
