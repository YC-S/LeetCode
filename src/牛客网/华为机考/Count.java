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
public class Count {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        char[] array = str.toCharArray();
        String str2 = sc.nextLine();
        char target = str2.toLowerCase().charAt(0);
        int res = 0;
        for (char c : array) {
            if (c == target) {
                res++;
            }
        }
        System.out.println(res);
    }
}
