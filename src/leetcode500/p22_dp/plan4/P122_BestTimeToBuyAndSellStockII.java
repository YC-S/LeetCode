package leetcode500.p22_dp.plan4;

public class P122_BestTimeToBuyAndSellStockII {
  public int maxProfit(int[] prices) {
    int res = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i + 1] > prices[i]) {
        res += prices[i + 1] - prices[i];
      }
    }
    return res;
  }
}
