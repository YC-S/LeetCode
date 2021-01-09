/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/22
 */
public class Example20 {

    static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static boolean checkdate(int mth, int day) {
        return (mth >= 1) && (mth <= 12) && (day >= 1) && (day <= days[mth - 1]);
    }

    public static void main(String[] args) {
        System.out.println(checkdate(1, 30));
        System.out.println(checkdate(2, 28));
    }

}
