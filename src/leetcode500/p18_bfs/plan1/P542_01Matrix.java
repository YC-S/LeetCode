package leetcode500.p18_bfs.plan1;

import java.util.LinkedList;
import java.util.Queue;

public class P542_01Matrix {
  public int[][] updateMatrix(int[][] matrix) {
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) queue.add(new int[] {i, j});
        else matrix[i][j] = Integer.MAX_VALUE;
      }
    }
    int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    while (queue.size() != 0) {
      int[] cur = queue.poll();
      for (int[] dir : dirs) {
        int r = cur[0] + dir[0];
        int c = cur[1] + dir[1];
        if (r < 0
            || r >= matrix.length
            || c < 0
            || c >= matrix[0].length
            || matrix[r][c] < matrix[cur[0]][cur[1]] + 1) continue;
        matrix[r][c] = matrix[cur[0]][cur[1]] + 1;
        queue.add(new int[] {r, c});
      }
    }
    return matrix;
  }
}
