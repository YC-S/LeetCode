package month_challenge._2020_april;

/**
 * @author shiyuanchen
 */
public class P5BestTimeToBuyStockII {
	public static int maxProfit(int[] prices) {
		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				res += prices[i] - prices[i - 1];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		int[] prices1 = {1, 2, 3, 4, 5};
		int[] prices2 = {7, 5, 4, 3, 1};
		System.out.println(maxProfit(prices));
		System.out.println(maxProfit(prices1));
		System.out.println(maxProfit(prices2));
	}
}
