package all_problems;

public class P1771_MaximizePalindromeLengthFromSubsequences {
  public int longestPalindrome(String word1, String word2) {
    int M = word1.length(), N = word2.length();
    int res = 0;
    int[][] dp = helper(word1 + word2);
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (word1.charAt(i) != word2.charAt(j)) continue;
        res = Math.max(res, 2 + dp[i + 1][M + j - 1]);
      }
    }
    return res;
  }

  private int[][] helper(String s) {
    int N = s.length();
    int[][] dp = new int[N][N];
    for (int i = N - 1; i >= 0; --i) {
      dp[i][i] = 1;
      for (int j = i + 1; j < N; j++) {
        if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
        else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
      }
    }
    return dp;
  }
}
