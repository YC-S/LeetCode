package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/07
 */
public class P66_PlusOne {

    public static int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] + carry == 10) {
                carry = 1;
                digits[i] = 0;
            } else {
                digits[i] += carry;
                carry = 0;
                return digits;
            }
        }
        if (digits[0] == 0 && carry == 1) {
            int[] newArray = new int[digits.length + 1];
            for (int i = 1; i < newArray.length; ++i) {
                newArray[i] = digits[i - 1];
            }
            newArray[0] = 1;
            return newArray;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
