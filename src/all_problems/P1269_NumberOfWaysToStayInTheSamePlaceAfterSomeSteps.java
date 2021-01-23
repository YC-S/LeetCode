package all_problems;

public class P1269_NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    public int numWays(int steps, int arrLen) {
        int maxPos = Math.min(steps, arrLen);
        long[][] dp = new long[steps + 1][maxPos + 1];

        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= steps; i++) {
            for (int j = 0; j < maxPos; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1] + (j > 0 ? dp[i - 1][j - 1] : 0)) % 1000000007;
            }
        }

        return (int) dp[steps][0];
    }
}
