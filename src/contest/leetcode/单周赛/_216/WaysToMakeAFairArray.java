package contest.leetcode.单周赛._216;

public class WaysToMakeAFairArray {
    public static int waysToMakeFair(int[] nums) {
        int count = 0;

        int[][] dp = new int[nums.length][2];
        int even = 0;
        int odd = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1) {
                even += nums[i];
            } else {
                odd += nums[i];
            }
        }
        dp[0] = new int[]{odd, even};

        for (int i = 1; i < dp.length; i++) {
            if (i % 2 == 1) {
                dp[i] = new int[]{dp[i - 1][0], dp[i - 1][1] - nums[i] + nums[i - 1]};
            } else {
                dp[i] = new int[]{dp[i - 1][0] - nums[i] + nums[i - 1], dp[i - 1][1]};
            }
        }

        for (int[] pair : dp) {
            if (pair[0] == pair[1]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 6, 4};
        System.out.println(waysToMakeFair(nums));
    }
}
