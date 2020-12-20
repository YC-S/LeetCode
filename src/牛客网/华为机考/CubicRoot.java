/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.华为机考;

import java.util.Scanner;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/16
 */
public class CubicRoot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double input = sc.nextDouble();
        int tmp = (int) Math.round(getCubicRoot(input) * 100);
        System.out.printf("%.1f", tmp / 100.0);
    }

    private static double getCubicRoot(double input) {
        double left = 0, right = input;
        while (left <= right) {
            double mid = left + (right - left) / 2.0;
            if (Math.abs(input - mid * mid * mid) < Math.exp(1)) {
                return mid;
            } else if (mid * mid * mid > input) {
                right = mid;
            } else if (mid * mid * mid < input) {
                left = mid;
            }
        }
        return -1;
    }
}
