package all_problems;

public class P1216_ValidPalindromeIII {
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();

        StringBuilder stringBuilder = new StringBuilder(s).reverse();
        int lps = lcs(s, stringBuilder.toString(), n, n);

        return (n - lps <= k);
    }

    /*
    longest palindromic subsequence:
    LCS of the given string & its reverse will be the longest palindromic sequence.
     */
    private int lcs(String X, String Y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
