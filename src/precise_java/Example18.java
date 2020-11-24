/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/22
 */
public class Example18 {

    public static void main(String[] args) {
        int[] freq = new int[6];
        for (int i = 0; i < 1000; i++) {
            int die = (int) (1 + 6 * Math.random());
            freq[die - 1] += 1;
        }
        for (int c = 1; c <= 6; c++) {
            System.out.println(c + " came up " + freq[c - 1] + " times");
        }

        String[] number = new String[20];
        for (int i = 0; i < number.length; i++) {
            number[i] = "A" + i;
        }
        for (String s : number) {
            System.out.println(s);
        }
    }

}
