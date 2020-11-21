/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/21
 */
public class GetMaximumGold {

    public static int getMaximumGold(int[][] grid) {
        int[] max = new int[]{0};
        int cur = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] != 0) {
                    dfs(grid, i, j, m, n, directions, 0, max);
                }
            }
        }
        return max[0];
    }

    private static void dfs(int[][] grid, int i, int j, int m, int n, int[][] directions, int cur, int[] max) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            max[0] = Math.max(max[0], cur);
            return;
        }
        int val = grid[i][j];
        grid[i][j] = 0;
        for (int[] direction : directions) {
            dfs(grid, i + direction[0], j + direction[1], m, n, directions, cur + val, max);
        }
        grid[i][j] = val;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        System.out.println(getMaximumGold(grid));
    }

}
