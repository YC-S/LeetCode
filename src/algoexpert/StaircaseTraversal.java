package algoexpert;

public class StaircaseTraversal {
    public static int staircaseTraversal(int height, int maxSteps) {
        // Write your code here.
        int[] dp = new int[height + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int step = 1;
            while (step <= maxSteps && step <= i) {
                dp[i] = dp[i] + dp[i - step];
                step++;
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(staircaseTraversal(4, 2));
    }
}
