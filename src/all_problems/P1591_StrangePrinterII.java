package all_problems;

import java.util.*;

public class P1591_StrangePrinterII {
    public boolean isPrintable(int[][] targetGrid) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[61];
        for (int i = 0; i <= 60; i++) graph.add(new ArrayList<>());
        for (int i = 1; i <= 60; i++) search(targetGrid, i, graph, inDegree);

        Deque<Integer> zeros = new ArrayDeque<>();
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < inDegree.length; i++) if (inDegree[i] == 0) zeros.add(i);

        while (!zeros.isEmpty()) {
            int cur = zeros.poll();
            if (!seen.add(cur)) continue;

            for (Integer nbh : graph.get(cur)) {
                inDegree[nbh]--;
                if (inDegree[nbh] == 0) zeros.add(nbh);
            }
        }
        return seen.size() == 61;
    }

    private void search(int[][] grid, int color, List<List<Integer>> graph, int[] inDegree) {
        // get range
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == color) {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }

        if (minX == Integer.MAX_VALUE) return;

        // check relations
        for (int i = minX; i <= maxX; i++)
            for (int j = minY; j <= maxY; j++) {
                if (grid[i][j] != color) {
                    graph.get(grid[i][j]).add(color); // to paint current color, we need to paint color in grid[i][j] first
                    inDegree[color]++;
                }
            }
    }
}
