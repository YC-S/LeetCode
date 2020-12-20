/*
 * Copyright (c) 2020. Yuanchen
 */

package jzOffer;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/15
 */
public class Add {

    public static void main(String[] args) {
        System.out.println(new Add().add(3, 7));
    }

    public int add(int num1, int num2) {
        int result;
        int ans;
        do {
            result = num1 ^ num2;
            ans = (num1 & num2) << 1;
            num1 = result;
            num2 = ans;
        } while (ans != 0);
        return result;
    }
}
