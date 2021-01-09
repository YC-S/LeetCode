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
public class P158ANextRound {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k, count = 0, tmp = 0;
        String[] strings = sc.nextLine().split(" ");
        n = Integer.parseInt(strings[0]);
        k = Integer.parseInt(strings[1]);
        for (int i = 0; i < k; i++) {
            tmp = sc.nextInt();
            if (tmp > 0) {
                count++;
            }
        }
        for (int i = k; i < n; i++) {
            int tmp2 = sc.nextInt();
            if (tmp2 == tmp && tmp2 > 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
