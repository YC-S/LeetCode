/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_may;

/**
 * @author shiyuanchen
 * @created 2020/05/08
 * @project LeetCode
 */
public class P8CheckIfItIsAStraightLine {

    public static boolean checkStraightLine(int[][] coordinates) {
        // y = kx + b
        int[] c1 = coordinates[0];
        int[] c2 = coordinates[1];
        /**
         * x1 y1
         * x2 y2
         * y = kx + b
         * y1 = kx1 + b
         * y2 = kx2 + b
         * y2 - y1 = k(x2 - x1)
         */
        double k = ((double) (c2[1] - c1[1])) / ((double) (c2[0] - c1[0]));
        double b = c1[1] - k * c1[0];
        for (int i = 2; i < coordinates.length; i++) {
            if (coordinates[i][1] != coordinates[i][0] * k + b) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        int[][] coordinates2 = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        System.out.println(checkStraightLine(coordinates));
        System.out.println(checkStraightLine(coordinates2));
    }
}
