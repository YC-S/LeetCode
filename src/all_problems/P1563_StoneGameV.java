package all_problems;

public class P1563_StoneGameV {
    public int stoneGameV(int[] stoneValue) {
        int N = stoneValue.length;

        // cache prefix
        int[] prefix = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        return helper(stoneValue, 0, N - 1, prefix, new Integer[N][N]);
    }

    private int helper(int[] stoneValue, int l, int r, int[] prefix, Integer[][] dp) {

        if (l == r) return 0;
        if (l + 1 == r) return Math.min(stoneValue[l], stoneValue[r]);

        if (dp[l][r] != null) return dp[l][r];

        int res = 0;

        // left: [l, i], right: [i + 1, r]
        for (int i = l; i < r; ++i) {

            int left = prefix[i + 1] - prefix[l];
            int right = prefix[r + 1] - prefix[i + 1];

            if (left > right) {  // go right
                res = Math.max(res, right + helper(stoneValue, i + 1, r, prefix, dp));
            } else if (left < right) {  // go left
                res = Math.max(res, left + helper(stoneValue, l, i, prefix, dp));
            } else {  // left == right: go whatever max
                res = Math.max(res, Math.max(helper(stoneValue, l, i, prefix, dp),
                        helper(stoneValue, i + 1, r, prefix, dp))
                        + left);
            }

        }

        return dp[l][r] = res;
    }
}
