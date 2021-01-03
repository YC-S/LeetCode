package contest.leetcode.单周赛._221;

public class Q3 {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = dfs(grid, 0, i);
        }
        return res;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r == grid.length)
            return c;

        if (grid[r][c] == 1) {
            if (c == grid[0].length - 1 || grid[r][c + 1] == -1)
                return -1;
            else {
                return dfs(grid, r + 1, c + 1);
            }
        } else {
            if (c == 0 || grid[r][c - 1] == 1)
                return -1;
            else {
                return dfs(grid, r + 1, c - 1);
            }
        }
    }
}
