/*
 * Copyright (c) 2020. Yuanchen
 */

package book.jzOffer;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/15
 */
public class StrToInt {

    public static void main(String[] args) {
        StrToInt solution = new StrToInt();
        System.out.println(solution.strToInt("-123"));
    }

    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean positive = true;
        int res = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            if (str.charAt(0) == '-') {
                positive = false;
            }
            for (int i = 1; i < str.length(); ++i) {
                if (!Character.isDigit(str.charAt(i))) {
                    return 0;
                } else {
                    res = res * 10 + str.charAt(i) - '0';
                }
            }
            return positive ? res : -res;
        }
        if (Character.isDigit(str.charAt(0))) {
            for (int i = 0; i < str.length(); ++i) {
                if (!Character.isDigit(str.charAt(i))) {
                    return 0;
                } else {
                    res = res * 10 + str.charAt(i) - '0';
                }
            }
        }
        return res;
    }
}
