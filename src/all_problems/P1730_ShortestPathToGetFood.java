package all_problems;

import java.util.LinkedList;
import java.util.Queue;

public class P1730_ShortestPathToGetFood {
    public int getFood(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '*') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{startRow, startCol});

        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] location = queue.poll();

                for (int[] d : dir) {
                    int nextRow = d[0] + location[0];
                    int nextCol = d[1] + location[1];
                    if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col || grid[nextRow][nextCol] == 'X')
                        continue;
                    if (grid[nextRow][nextCol] == '#') return step;
                    grid[nextRow][nextCol] = 'X';  // mark as visited
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }

        return -1;
    }
}