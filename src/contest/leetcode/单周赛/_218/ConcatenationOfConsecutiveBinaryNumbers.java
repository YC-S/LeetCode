/*
 * Copyright (c) 2020. Yuanchen
 */

package contest.leetcode.单周赛._218;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/05
 */
public class ConcatenationOfConsecutiveBinaryNumbers {
    /*
     * Copyright (c) 2020. Yuanchen
     */


    public static int concatenatedBinary(int n) {
        int MOD = 1_000_000_007;
        long sum = 0;
        for (int i = 1; i <= n; i++)
            sum = (sum * (int) Math.pow(2, Integer.toBinaryString(i).length()) + i) % MOD; // sum = ((sum << Integer.toBinaryString(i).length()) + i) % MOD;

        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println(concatenatedBinary(1));
        System.out.println(concatenatedBinary(2));
        System.out.println(concatenatedBinary(42));
        System.out.println(concatenatedBinary(6812));
        //727837408
    }
}



