/*
 * Copyright (c) 2020. Yuanchen
 */

package contest._217;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/28
 */
public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int cur = 0;
            for (int i : account) {
                cur += i;
            }
            max = Math.max(cur, max);
        }
        return max;
    }

}
