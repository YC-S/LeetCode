package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.PriorityQueue;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/10
 */
public class P407_TrappingRainWaterII {

    /**
     * Use priority queue to sort.
     */
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        int n = heightMap.length;
        int m = heightMap[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return heightMap[a / m][a % m] - heightMap[b / m][b % m];
        });
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    pq.add(i * m + j);
                    vis[i][j] = true;
                }
            }
        }
        int maxHeight = 0;
        int water = 0;
        while (pq.size() != 0) {
            int idx = pq.remove();
            int r = idx / m;
            int c = idx % m;

            maxHeight = Math.max(maxHeight, heightMap[r][c]);
            water += maxHeight - heightMap[r][c];
            for (int d = 0; d < 4; d++) {
                int x = r + dir[d][0];
                int y = c + dir[d][1];
                if (x >= 0 && y >= 0 && x < n && y < m && !vis[x][y]) {
                    vis[x][y] = true;
                    pq.add(x * m + y);
                }
            }
        }
        return water;
    }
}
