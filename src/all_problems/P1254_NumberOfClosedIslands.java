package all_problems;

public class P1254_NumberOfClosedIslands {
    int fill(int[][] g, int i, int j) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[i].length || g[i][j] != 0)
            return 0;
        return (g[i][j] = 1) + fill(g, i + 1, j) + fill(g, i, j + 1)
                + fill(g, i - 1, j) + fill(g, i, j - 1);
    }

    public int closedIsland(int[][] grid) {
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[i].length; ++j)
                if (i * j * (i - grid.length + 1) * (j - grid[i].length + 1) == 0)
                    fill(grid, i, j);
        int res = 0;
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[i].length; ++j)
                res += fill(grid, i, j) > 0 ? 1 : 0;
        return res;
    }
}
