package all_problems;

import java.util.Arrays;

public class P354_RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length < 2) {
            return 0;
        }

        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        // print2DArray(envelopes);

        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (envelopes[j][0] > envelopes[i][0] &&
                        envelopes[j][1] > envelopes[i][1] &&
                        dp[j] < dp[i] + 1) {
                    dp[j] = dp[i] + 1;
                }
            }
        }

        int max = -1;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
