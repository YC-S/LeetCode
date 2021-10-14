package leetcode500.p22_dp.plan4;

public class P121_BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    if (prices.length == 1) return 0;
    int max = 0, sofarMin = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (sofarMin > prices[i]) {
        sofarMin = prices[i];
      } else {
        max = Math.max(max, prices[i] - sofarMin);
      }
    }
    return max;
  }
}
