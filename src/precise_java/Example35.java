/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class Example35 {

    static int max(int x1, int... xr) {
        int res = x1;
        for (int x : xr) {
            res = max(res, x);
        }
        return res;
    }

    static int max(int x, int y) {
        return Math.max(x, y);
    }
}
