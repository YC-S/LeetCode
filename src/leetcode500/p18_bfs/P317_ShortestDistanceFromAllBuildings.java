package leetcode500.p18_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class P317_ShortestDistanceFromAllBuildings {
  private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int shortestDistance(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    // Total Matrix to store total distance sum for each empty cell.
    int[][] total = new int[m][n];
    int emptyLandValue = 0;
    int minDist = Integer.MAX_VALUE;
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        // Start a BFS from each house.
        if (grid[i][j] == 1) {
          minDist = Integer.MAX_VALUE;
          // Use a queue to perform a BFS, starting from the cell at (r, c).
          Queue<int[]> q = new LinkedList<>();
          q.offer(new int[] {i, j});
          int steps = 0;
          while (q.size() != 0) {
            steps++;
            for (int level = q.size(); level > 0; --level) {
              int[] curr = q.poll();
              for (int[] dir : dirs) {
                int nextRow = curr[0] + dir[0];
                int nextCol = curr[1] + dir[1];
                // For each cell with the value equal to empty land value
                // add distance and decrement the cell value by 1.
                if (nextRow >= 0
                    && nextRow < m
                    && nextCol >= 0
                    && nextCol < n
                    && grid[nextRow][nextCol] == emptyLandValue) {
                  grid[nextRow][nextCol]--;
                  total[nextRow][nextCol] += steps;

                  q.offer(new int[] {nextRow, nextCol});
                  minDist = Math.min(minDist, total[nextRow][nextCol]);
                }
              }
            }
          }
          // Decrement empty land value to be searched in next iteration.
          emptyLandValue--;
        }
      }
    }
    return minDist == Integer.MAX_VALUE ? -1 : minDist;
  }
}
