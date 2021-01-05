/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_july;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/07
 */
public class P7IslandPerimeter {

  public int islandPerimeter(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    int result = 0;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == 1) {
          result += 4;

          if (r > 0 && grid[r - 1][c] == 1) {
            result -= 2;
          }

          if (c > 0 && grid[r][c - 1] == 1) {
            result -= 2;
          }
        }
      }
    }

    return result;
  }
}
