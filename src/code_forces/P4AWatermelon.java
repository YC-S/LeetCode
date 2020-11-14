/*
 * Copyright (c) 2020. Yuanchen
 */

package code_forces;

import java.util.Scanner;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/14
 */
public class P4AWatermelon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = Integer.parseInt(sc.nextLine());
        if (w % 2 == 0 && w != 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
