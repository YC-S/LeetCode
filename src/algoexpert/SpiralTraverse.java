package algoexpert;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        List<Integer> res = new ArrayList<>();
        int n = array.length;
        int m = array[0].length;
        int min = Math.min(m, n);
        int layer = min % 2 == 1 ? min / 2 + 1 : min / 2;
        if (m == n && m == 1) {
            res.add(array[0][0]);
            return res;
        }
        for (int i = 0; i < layer; i++) {
            for (int j = i; j < m - i - 1; j++) {
                res.add(array[i][j]);
            }
            for (int j = i; j < n - i - 1; j++) {
                res.add(array[j][m - i - 1]);
            }
            for (int j = m - i - 1; j > i; j--) {
                res.add(array[n - i - 1][j]);
                if (i == n / 2) break;
            }
            for (int j = n - i - 1; j > i; j--) {
                res.add(array[j][i]);
                if (i == m / 2) break;
            }
        }
        if (m == n && m % 2 == 1) {
            res.add(array[m % 2][m % 2]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        int[][] array2 = new int[][]{{1}};
        int[][] array3 = new int[][]{{4, 2, 3, 6, 7, 8, 1, 9, 5, 10},
                {12, 19, 15, 16, 20, 18, 13, 17, 11, 14}};
        int[][] array4 = new int[][]{{1, 2, 3, 4}, {10, 11, 12, 5}, {9, 8, 7, 6}};
        int[][] array5 = new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        int[][] array6 = new int[][]{{1, 2, 3}, {12, 13, 4}, {11, 14, 5}, {10, 15, 6}, {9, 8, 7}};
        System.out.println(spiralTraverse(array));
        System.out.println(spiralTraverse(array2));
        System.out.println(spiralTraverse(array3));
        System.out.println(spiralTraverse(array4));
        System.out.println(spiralTraverse(array5));
        System.out.println(spiralTraverse(array6));
    }
}
