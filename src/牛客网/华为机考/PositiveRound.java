/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.华为机考;

import java.util.Scanner;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/18
 */
public class PositiveRound {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        if (x * 10 % 10 < 5) {
            System.out.println((int) x * 10 / 10);
        } else {
            System.out.println((int) x * 10 / 10 + 1);
        }
    }
}
