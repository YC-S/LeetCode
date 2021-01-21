package all_problems;

public class P1259_HandshakesThatDontCross {
    public int numberOfWays(int num_people) {
        long mod = (long) 1e9 + 7;
        long[] dp = new long[num_people / 2 + 1];
        dp[0] = 1;
        for (int k = 1; k <= num_people / 2; ++k) {
            for (int i = 0; i < k; ++i) {
                dp[k] = (dp[k] + dp[i] * dp[k - 1 - i]) % mod;
            }
        }
        return (int) dp[num_people / 2];
    }
}
