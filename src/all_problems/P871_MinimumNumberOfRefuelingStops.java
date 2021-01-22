package all_problems;

public class P871_MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        long[] dp = new long[stations.length + 1];
        dp[0] = startFuel;
        for (int i = 0; i < stations.length; ++i)
            for (int t = i; t >= 0 && dp[t] >= stations[i][0]; --t)
                dp[t + 1] = Math.max(dp[t + 1], dp[t] + stations[i][1]);
        for (int t = 0; t <= stations.length; ++t)
            if (dp[t] >= target) return t;
        return -1;
    }
}
