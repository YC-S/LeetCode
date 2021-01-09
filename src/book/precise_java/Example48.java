/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class Example48 {

    public static void main(String[] args) {
        double d;
        d = 12;
        byte b1 = 123;
        byte b2;
        b2 = 123 + 1;
        b2 = (byte) (b1 + 1);
        int x = 0;
        x += 1.5;
        x += 1.5;
        System.out.println(x);
    }

}
