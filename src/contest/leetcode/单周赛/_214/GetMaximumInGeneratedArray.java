package contest.leetcode.单周赛._214;

public class GetMaximumInGeneratedArray {
    public static int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int max = 0;
        for (int i = 2; i < dp.length; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
                max = Math.max(dp[i], max);
            } else {
                dp[i] = dp[i / 2 + 1] + dp[i / 2];
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(7));
        System.out.println(getMaximumGenerated(2));
        System.out.println(getMaximumGenerated(3));
        System.out.println(getMaximumGenerated(4));
    }
}
