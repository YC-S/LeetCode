package array;

// Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to
// the following rules:
//
// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
  public static boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      Set<Character> set = new HashSet<>();
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.' && !set.contains(board[i][j])) {
          set.add(board[i][j]);
        } else if (board[i][j] == '.') {
          continue;
        } else {
          return false;
        }
      }
    }

    for (int i = 0; i < 9; i++) {
      Set<Character> set = new HashSet<>();
      for (int j = 0; j < 9; j++) {
        if (board[j][i] != '.' && !set.contains(board[j][i])) {
          set.add(board[j][i]);
        } else if (board[j][i] == '.') {
          continue;
        } else {
          return false;
        }
      }
    }

    for (int k = 0; k < 3; k++) {
      for (int l = 0; l < 3; l++) {
        Set<Character> set = new HashSet<>();
        for (int i = 3 * k; i < 3 * (k + 1); i++) {
          for (int j = 3 * l; j < 3 * (l + 1); j++) {
            if (board[i][j] != '.' && !set.contains(board[i][j])) {
              set.add(board[i][j]);
            } else if (board[i][j] == '.') {
              continue;
            } else {
              return false;
            }
          }
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    char[][] board =
        new char[][] {
          {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

    char[][] board2 =
        new char[][] {
          {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

    char[][] board3 =
        new char[][] {
          {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
          {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
          {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
          {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
          {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
          {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
          {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
          {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
          {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

    System.out.println(isValidSudoku(board));
    System.out.println(isValidSudoku(board2));
    System.out.println(isValidSudoku(board3));
  }
}
