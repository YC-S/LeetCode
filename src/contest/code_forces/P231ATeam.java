/*
 * Copyright (c) 2020. Yuanchen
 */

package contest.code_forces;

import java.util.Scanner;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/14
 */
public class P231ATeam {

    public static void main(String[] args) {
        int n, a, b, c, count = 0, number = 0;
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            a = Integer.parseInt(line[0]);
            b = Integer.parseInt(line[1]);
            c = Integer.parseInt(line[2]);
            if (a == 1) {
                number++;
            }
            if (b == 1) {
                number++;
            }
            if (c == 1) {
                number++;
            }
            if (number >= 2) {
                count++;
            }
            number = 0;
        }
        System.out.println(count);
    }
}
