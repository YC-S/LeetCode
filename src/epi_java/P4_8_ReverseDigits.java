/*
 * Copyright (c) 2020. Yuanchen
 */

package epi_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/13
 */
public class P4_8_ReverseDigits {

    public static long reverse(int x) {
        long res = 0;
        while (x != 0) {
            int lastDig = x % 10;
            x /= 10;
            res = res * 10 + lastDig;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(-1132));
        System.out.println(reverse(42));
        System.out.println(reverse(-314));
    }
}
