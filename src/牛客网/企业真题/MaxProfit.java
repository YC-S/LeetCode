/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.企业真题;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/04
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int price : prices) {
            if (price < minprice) {
                minprice = price;
            } else if (price - minprice > maxprofit) {
                maxprofit = price - minprice;
            }
        }
        return maxprofit;
    }
}
