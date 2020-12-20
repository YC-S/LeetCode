/*
 * Copyright (c) 2020. Yuanchen
 */

package jzOffer;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/15
 */
public class FindGreatestSumOfSubArray {

    public static int FindGreatestSumOfSubArray(int[] array) {
        int curSum = 0;
        int left = 0;
        int right = 0;
        int res = array[0];
        for (int i = 0; i < array.length; ++i) {
            if (curSum + array[i] > res || curSum + array[i] > 0) {
                curSum += array[i];
                res = Math.max(curSum, res);
            } else {
                curSum = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(FindGreatestSumOfSubArray(arr));
    }
}
