/*
 * Copyright (c) 2020. Yuanchen
 */

package book.jzOffer;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/15
 */
public class IsContinuous {


    public static void main(String[] args) {
        System.out.println(isContinuous(new int[]{0, 3, 2, 6, 4}));
    }


    public static boolean isContinuous(int[] numbers) {
        int[] d = new int[14];
        d[0] = -5;
        int len = numbers.length;
        int max = -1;
        int min = 14;
        for (int i = 0; i < len; i++) {
            d[numbers[i]]++;
            if (numbers[i] == 0) {
                continue;
            }
            if (d[numbers[i]] > 1) {
                return false;
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }

        }
        return max - min < 5;
    }
}
