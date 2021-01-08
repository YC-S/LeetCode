package all_problems;

import java.util.Arrays;

public class P1621_NumberOfSetsOfKNonOverlappingLineSegments {
    public int numberOfSets(int n, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int mod = 1_000_000_007;
        for (int i = 1; i <= k; i++) {
            int sum = dp[0];
            dp[0] = 0;
            for (int j = 1; j < n; j++) {
                int prev = dp[j];
                dp[j] = (sum + dp[j - 1]) % mod;
                sum = (sum + prev) % mod;
            }
        }
        return dp[n - 1];
    }
}
