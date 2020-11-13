/*
 * Copyright (c) 2020. Yuanchen
 */

package algocast;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/12
 */
public class P7SearchIn2DArray {

    public int[] searchIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{-1, -1};
        }
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (target == matrix[i][j]) {
                return new int[]{i, j};
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{-1, -1};
    }


}
