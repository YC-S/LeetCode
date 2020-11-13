/*
 * Copyright (c) 2020. Yuanchen
 */

package algocast;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/12
 */
public class P6SingleNumber {

    public static void main(String[] args) {
        P6SingleNumber solution = new P6SingleNumber();
        System.out.println(solution.singleNumberWithXor(new int[]{1, 2, 3, 2, 3}));
    }

    public int singleNumberWithXor(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
