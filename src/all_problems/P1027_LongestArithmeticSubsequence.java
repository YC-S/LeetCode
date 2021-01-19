package all_problems;

import java.util.HashMap;
import java.util.Map;

public class P1027_LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] A) {
        int res = 2, n = A.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j < n; j++) {
            dp[j] = new HashMap<>();
            for (int i = 0; i < j; ++i) {
                int d = A[j] - A[i];
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }
}
