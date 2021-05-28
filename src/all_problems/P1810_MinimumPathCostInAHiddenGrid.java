package all_problems;

import java.util.PriorityQueue;

public class P1810_MinimumPathCostInAHiddenGrid {
  int[][] dxys = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  char[] dirs = new char[] {'U', 'D', 'L', 'R'};

  public int findShortestPath(GridMaster master) {
    int[][] grid = new int[200][200];
    for (int i = 0; i < 200; i++) {
      for (int j = 0; j < 200; j++) {
        grid[i][j] = -1;
      }
    }
    grid[99][99] = 0;
    int[] target = new int[] {-100, -100};
    fillGrid(master, 99, 99, grid, target);
    boolean[][] visited = new boolean[200][200];
    PriorityQueue<int[]> pq =
        new PriorityQueue<>(
            (a, b) -> {
              if (a[2] == b[2]) {
                return 0;
              }
              return a[2] < b[2] ? -1 : 1;
            });
    pq.offer(new int[] {99, 99, 0});
    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int row = cur[0];
      int col = cur[1];
      int cost = cur[2];
      if (row == target[0] && col == target[1]) {
        return cost;
      }
      if (visited[row][col]) {
        continue;
      }
      visited[row][col] = true;
      for (int[] dxy : dxys) {
        int nextRow = row + dxy[0];
        int nextCol = col + dxy[1];
        if (nextRow < 0
            || nextRow >= 200
            || nextCol < 0
            || nextCol >= 200
            || visited[nextRow][nextCol]
            || grid[nextRow][nextCol] == -1) {
          continue;
        }
        int nextCost = cost + grid[nextRow][nextCol];
        pq.offer(new int[] {nextRow, nextCol, nextCost});
      }
    }
    return -1;
  }

  private void fillGrid(GridMaster master, int row, int col, int[][] grid, int[] target) {

    if (master.isTarget()) {
      target[0] = row;
      target[1] = col;
    }

    for (int i = 0; i < 4; i++) {
      char ch = dirs[i];
      int[] dxy = dxys[i];
      int nr = row + dxy[0];
      int nc = col + dxy[1];
      if (master.canMove(ch) && grid[nr][nc] == -1) {
        int val = master.move(ch);
        grid[nr][nc] = val;
        fillGrid(master, nr, nc, grid, target);
        if (i == 0 || i == 1) {
          master.move(dirs[1 - i]);
        } else {
          master.move(dirs[5 - i]);
        }
      }
    }
  }

  static class GridMaster {
    boolean canMove(char direction) {
      return false;
    }

    int move(char direction) {
      return 0;
    }

    boolean isTarget() {
      return false;
    }
  }
}
