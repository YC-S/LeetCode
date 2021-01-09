/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/26
 */
public class Example83 {

    static int sqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("sqrt: negative argument");
        }
        int tmp, y = 0, b = 0x8000, bshft = 15, v = x;
        do {
            if (v >= (tmp = (y << 1) + b << bshft--)) {
                y += b;
                v -= tmp;
            }
        } while ((b >>= 1) > 0);
        assert (long) y * y <= x && (long) (y + 1) * (y + 1) > x;
        return y;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(16));
    }
}
