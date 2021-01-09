/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class Example33 {

    static double m(int x, double y) {
        return x + y + 1;
    }

    static double m(double x, double y) {
        return x + y + 3;
    }

    public static void main(String[] args) {
        System.out.println(m(10, 20));
        System.out.println(m(10, 20.0));
        System.out.println(m(10.0, 20));
        System.out.println(m(10.0, 20.0));
    }

    double m(int i) {
        return i;
    }

    boolean m(boolean b) {
        return !b;
    }

}
