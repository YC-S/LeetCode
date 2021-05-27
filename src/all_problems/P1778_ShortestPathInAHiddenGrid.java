package all_problems;

public class P1778_ShortestPathInAHiddenGrid {
  int[][] grid = new int[2000][2000];
  int[][] visited = new int[2000][2000];
  int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
  char[] dir = {'L', 'U', 'R', 'D'};
  int minDist = Integer.MAX_VALUE;
  boolean found = false;

  public int findShortestPath(GridMaster master) {
    String key = 0 + ":" + 0;
    grid[1000][1000] = 1;
    int depth = 50;
    while (!found && depth <= 250000) {
      visited[1000][1000] = depth;
      for (int i = 0; i < dir.length; i++) {
        findShortestPath(1000, 1000, i, depth, master);
      }
      depth *= 2;
    }
    return found ? minDist - 1 : -1;
  }

  public void findShortestPath(int x, int y, int d, int depth, GridMaster master) {

    int val = grid[x][y];

    if (val <= depth && master.canMove(dir[d])) {
      int xx = x + dirs[d][0];
      int yy = y + dirs[d][1];

      if (grid[xx][yy] == 0
          || grid[xx][yy] > val + 1
          || (grid[xx][yy] == val + 1 && visited[xx][yy] < depth)) {

        master.move(dir[d]);
        grid[xx][yy] = val + 1;
        visited[xx][yy] = depth;
        if (master.isTarget()) {
          minDist = Math.min(minDist, val + 1);
          found = true;
        }

        for (int i = 0; i < dir.length; i++) {
          findShortestPath(xx, yy, i, depth, master);
        }
        master.move(dir[(d + 2) % dir.length]);
      }
    }
  }

  static class GridMaster {
    boolean canMove(char direction) {
      return false;
    }

    void move(char direction) {}

    boolean isTarget() {
      return false;
    }
  }
}
