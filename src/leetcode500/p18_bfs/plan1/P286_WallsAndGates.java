package leetcode500.p18_bfs.plan1;

import java.util.LinkedList;
import java.util.Queue;

public class P286_WallsAndGates {
  public void wallsAndGates(int[][] rooms) {
    int m = rooms.length;
    if (m == 0) return;
    int n = rooms[0].length;
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (rooms[i][j] == 0) queue.add(new int[] {i, j});
      }
    }
    int[][] DIRS = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      for (int[] dir : DIRS) {
        int r = cur[0] + dir[0];
        int c = cur[1] + dir[1];
        if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != Integer.MAX_VALUE) continue;
        rooms[r][c] = rooms[cur[0]][cur[1]] + 1;
        queue.add(new int[] {r, c});
      }
    }
  }
}
