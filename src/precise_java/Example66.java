/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class Example66 {

    static int monthDays(int y, String month) {
        switch (month) {
            case "Apr":
            case "Jun":
            case "Sep":
            case "Nov":
                return 30;
            case "Feb":
                return leapYear(y) ? 29 : 28;
            default:
                return 31;
        }
    }

    static boolean leapYear(int y) {
        return y % 4 == 0 && y % 100 != 0 || y % 400 == 0;
    }

    public static void main(String[] args) {
        System.out.println(monthDays(2000, "Apr"));
        System.out.println(monthDays(2020, "Feb"));
    }

}
