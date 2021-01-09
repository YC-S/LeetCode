/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_april;

/**
 * @author shiyuanchen
 * @created 2020/04/27
 * @project LeetCode
 */
public class P27MaximalSquare {

    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length, result = 0;
        int[][] b = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j - 1], b[i - 1][j - 1]),
                        b[i - 1][j]) + 1;
                    // update result
                    result = Math.max(b[i][j], result);
                }
            }
        }
        return result * result;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1',}, {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(matrix));
    }
}
