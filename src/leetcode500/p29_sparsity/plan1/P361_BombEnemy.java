package leetcode500.p29_sparsity.plan1;

public class P361_BombEnemy {
  public int maxKilledEnemies(char[][] grid) {
    if (grid.length == 0) return 0;
    int rows = grid.length;
    int cols = grid[0].length;
    int maxCount = 0, rowHits = 0;
    int[] colHits = new int[cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (col == 0 || grid[row][col - 1] == 'W') {
          rowHits = 0;
          for (int k = col; k < cols; k++) {
            if (grid[row][k] == 'W') {
              break;
            } else if (grid[row][k] == 'E') {
              rowHits++;
            }
          }
        }

        if (row == 0 || grid[row - 1][col] == 'W') {
          colHits[col] = 0;
          for (int k = row; k < rows; k++) {
            if (grid[k][col] == 'W') {
              break;
            } else if (grid[k][col] == 'E') {
              colHits[col]++;
            }
          }
        }
        if (grid[row][col] == '0') {
          maxCount = Math.max(maxCount, rowHits + colHits[col]);
        }
      }
    }
    return maxCount;
  }
}
