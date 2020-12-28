/*
 * Copyright (c) 2020. Yuanchen
 */

package contest.leetcode.单周赛._220;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/19
 */
public class Q1 {

    public static String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); ++i) {
            if (number.charAt(i) >= '0' && number.charAt(i) <= '9') {
                sb.append(number.charAt(i));
            }
        }
        int i = 0;
        int n = sb.length();
        StringBuilder res = new StringBuilder();
        while (n - i > 4) {
            res.append(sb.substring(i, i + 3));
            res.append("-");
            i += 3;
        }
        if (n - i == 2) {
            res.append(sb.substring(i, i + 2));
        } else if (n - i == 1) {
            res.append(sb.substring(i, i + 1));
        } else if (n - i == 3) {
            res.append(sb.substring(i, i + 3));
        } else if (n - i == 4) {
            res.append(sb.substring(i, i + 2));
            res.append("-");
            res.append(sb.substring(i + 2, i + 4));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(reformatNumber("123"));
        System.out.println(reformatNumber("1-23-45 6"));
        System.out.println(reformatNumber("123 4-567"));
        System.out.println(reformatNumber("123 4-5678"));
        System.out.println(reformatNumber("12"));
    }
}
