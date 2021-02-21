package contest.leetcode.单周赛._229;

public class P3 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] multipliers = {3, 2, 1};
        P3 p3 = new P3();
        System.out.println(p3.maximumScore(nums, multipliers));
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        Integer[][] memo = new Integer[m + 1][m + 1];
        return dp(0, 0, m, n, memo, nums, multipliers);
    }

    private int dp(int l, int i, int m, int n, Integer[][] memo, int[] nums, int[] multipliers) {
        if (i == m) return 0; // Picked enough m operations
        if (memo[l][i] != null) return memo[l][i];
        int pickLeft = dp(l + 1, i + 1, m, n, memo, nums, multipliers) + nums[l] * multipliers[i]; // Pick the left side
        int pickRight = dp(l, i + 1, m, n, memo, nums, multipliers) + nums[n - (i - l) - 1] * multipliers[i]; // Pick the right side
        return memo[l][i] = Math.max(pickLeft, pickRight);
    }
}
