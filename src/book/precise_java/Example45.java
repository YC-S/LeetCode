/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class Example45 {

    public static void main(String[] args) {
        int max = 2147483547;
        int min = -2147483548;
        System.out.println(max + 1);
        System.out.println(min - 1);
        System.out.println(-min);
        System.out.println(10 / 3);
        System.out.println(10 / (-3));
        System.out.println((-10) / 3);
        System.out.println((-10) / (-3));
        System.out.println(10 % 3);
        System.out.println(10 % (-3));
        System.out.println(-10 % (-3));
        System.out.println((-10) % (-3));
    }

}
