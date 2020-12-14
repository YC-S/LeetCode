/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/10
 */
public class P417_PacificAtlanticWaterFlow {

    /**
     * DFS to traverse the matrix. each time check four directions.
     */

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return Collections.EMPTY_LIST;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            find(p, i, 0, matrix, 0);
            find(a, i, n - 1, matrix, 0);
        }

        for (int i = 0; i < n; i++) {
            find(p, 0, i, matrix, 0);
            find(a, m - 1, i, matrix, 0);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p[i][j] && a[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }

        return result;
    }

    private void find(boolean[][] visit, int i, int j, int[][] matrix, int val) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visit[i][j] || matrix[i][j] < val) {
            return;
        }

        visit[i][j] = true;
        find(visit, i + 1, j, matrix, matrix[i][j]);
        find(visit, i - 1, j, matrix, matrix[i][j]);
        find(visit, i, j + 1, matrix, matrix[i][j]);
        find(visit, i, j - 1, matrix, matrix[i][j]);
    }
}
