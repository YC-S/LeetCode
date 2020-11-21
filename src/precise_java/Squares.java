/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/20
 */
public class Squares {

    static int squares(int a, int b) {
        int count = 0;
        int i = a;
        for (; i <= b; ++i) {
            double x = Math.sqrt(i);
            if (x % 1 == 0) {
                count++;
                i = (int) (x + 1) * (int) (x + 1) - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(squares(12, 17));
    }

}
