package all_problems;

public class P1745_PalindromePartitioningIV {
    public boolean checkPartitioning(String s) {
        int N = s.length();
        char[] A = s.toCharArray();


        boolean[][] dp = new boolean[N][N];
        for (int i = N - 1; i >= 0; --i) {
            for (int j = i; j < N; ++j) {
                if (A[i] == A[j]) dp[i][j] = (i + 1 > j - 1 || dp[i + 1][j - 1]);
                else dp[i][j] = false;
            }
        }


        for (int i = 1; i < N - 1; ++i) {
            for (int j = i; j < N - 1; ++j) {
                if (dp[0][i - 1] && dp[i][j] && dp[j + 1][N - 1]) return true;
            }
        }

        return false;
    }
}
