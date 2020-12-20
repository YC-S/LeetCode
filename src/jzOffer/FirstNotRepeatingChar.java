/*
 * Copyright (c) 2020. Yuanchen
 */

package jzOffer;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/15
 */
public class FirstNotRepeatingChar {

    public static int FirstNotRepeatingChar(String str) {
        int[] array = new int[128];
        for (int i = 0; i < str.length(); ++i) {
            array[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); ++i) {
            if (array[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("google"));
    }
}
