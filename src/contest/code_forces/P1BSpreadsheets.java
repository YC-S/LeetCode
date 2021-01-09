/*
 * Copyright (c) 2020. Yuanchen
 */

package contest.code_forces;

import java.util.Scanner;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/12
 */
public class P1BSpreadsheets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            helper(s);
        }
    }

    private static void helper(String s) {
        boolean isFormatRXCY = false;
        int i = 0;
        while (i < s.length()) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                break;
            }
            i++;
        }
        while (i < s.length()) {
            if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                isFormatRXCY = true;
                break;
            }
            i++;
        }
        if (isFormatRXCY) {
            int row = 0;
            int idx = 1;
            int count = 0;
            while (idx < s.length()) {
                if ('0' <= s.charAt(idx) && s.charAt(idx) <= '9') {
                    row = row * 10 + s.charAt(idx) - '0';
                    count++;
                } else {
                    count = 0;
                    break;
                }
                idx++;
            }
            int col = 0;
            while (idx < s.length()) {
                if ('0' <= s.charAt(idx) && s.charAt(idx) <= '9') {
                    col = col * 10 + s.charAt(idx) - '0';
                    count++;
                }
                idx++;
            }
            StringBuilder sb = new StringBuilder();
            while (col != 0) {
                if (col % 26 == 0) {
                    sb.append('Z');
                    col -= 26;
                } else {
                    int last = col % 26;
                    sb.append((char) (last + 'A' - 1));
                }
                col /= 26;
            }
            String res = sb.reverse().append(row).toString();
            System.out.println(res);
        } else {
            int row = 0;
            int idx = 0;
            int count = 0;
            int col = 0;
            while (idx < s.length()) {
                if ('A' <= s.charAt(idx) && s.charAt(idx) <= 'Z') {
                    col = col * 26 + s.charAt(idx) - 'A' + 1;
                    count++;
                } else {
                    count = 0;
                    break;
                }
                idx++;
            }
            while (idx < s.length()) {
                row = row * 10 + s.charAt(idx) - '0';
                count++;
                idx++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("R").append(row).append("C").append(col);
            System.out.println(sb);
        }
    }
}
