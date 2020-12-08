/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.企业真题;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/04
 */
public class MaxWater {

    public long maxWater(int[] arr) {
        int a = 0;
        int b = arr.length - 1;
        int max = 0;
        int leftmax = 0;
        int rightmax = 0;
        while (a <= b) {
            leftmax = Math.max(leftmax, arr[a]);
            rightmax = Math.max(rightmax, arr[b]);
            if (leftmax < rightmax) {
                max += (leftmax - arr[a]);
                a++;
            } else {
                max += (rightmax - arr[b]);
                b--;
            }
        }
        return max;
    }

}
