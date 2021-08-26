package leetcode500.p23_dp_string_match.plan1;

public class P727_MinimumWindowSubsequence {
  public String minWindow(String s1, String s2) {
    int m = s2.length(), n = s1.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int j = 0; j <= n; j++) {
      dp[0][j] = j + 1;
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (s2.charAt(i - 1) == s1.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = dp[i][j - 1];
        }
      }
    }

    int start = 0, len = n + 1;
    for (int j = 1; j <= n; j++) {
      if (dp[m][j] != 0) {
        if (j - dp[m][j] + 1 < len) {
          start = dp[m][j] - 1;
          len = j - dp[m][j] + 1;
        }
      }
    }
    return len == n + 1 ? "" : s1.substring(start, start + len);
  }
}
