package all_problems;

public class P1643_KthSmallestInstructions {
    public String kthSmallestPath(int[] destination, int k) {

        int ti = destination[0], tj = destination[1];
        int[][] dp = new int[ti + 1][tj + 1];
        for (int i = ti; i >= 0; i--) {
            for (int j = tj; j >= 0; j--) {
                if (i == ti && j == tj) {
                    dp[i][j] = 1;
                } else if (i == ti) {
                    dp[i][j] = dp[i][j + 1];
                } else if (j == tj) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }


        // in each (i, j), we have dp[i][j] kind of instructions, which equal to dp[i][j+1] + dp[i+1][j]
        // all dp[i][j+1] kinds of instructions are lexicographically smaller than the left dp[i+1][j] kinds of instructions.
        // we can just compare k with dp[i][j+1] to determin how to choose next step.

        StringBuilder sb = new StringBuilder();
        helper(dp, 0, 0, k, sb);
        return sb.toString();
    }

    private void helper(int[][] dp, int i, int j, int k, StringBuilder sb) {

        if (i == dp.length - 1) {
            // if we came to most down position then we can only go right
            while (++j < dp[0].length) sb.append("H");
            return;
        }
        if (j == dp[0].length - 1) {
            //if we came to most right position then we can only go down
            while (++i < dp.length) sb.append("V");
            return;
        }
        if (dp[i][j + 1] >= k) {
            //if k is smaller than the first dp[i][j+1] solutions, then we should go right
            sb.append("H");
            helper(dp, i, j + 1, k, sb);
        } else {
            //else we go donw, and we should also minus the first dp[i][j+1] solutions from k
            sb.append("V");
            helper(dp, i + 1, j, k - dp[i][j + 1], sb);
        }
    }
}
