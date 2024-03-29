package leetcode500.p22_dp.plan8;

public class P471_EncodeStringWithShortestLength {
  public String encode(String s) {
    String[][] dp = new String[s.length()][s.length()];

    for (int l = 0; l < s.length(); l++) {
      for (int i = 0; i < s.length() - l; i++) {
        int j = i + l;
        String substr = s.substring(i, j + 1);
        // Checking if string length < 5. In that case, we know that encoding will not help.
        if (j - i < 4) {
          dp[i][j] = substr;
        } else {
          dp[i][j] = substr;
          // Loop for trying all results that we get after dividing the strings into 2 and combine
          // the   results of 2 substrings
          for (int k = i; k < j; k++) {
            if ((dp[i][k] + dp[k + 1][j]).length() < dp[i][j].length()) {
              dp[i][j] = dp[i][k] + dp[k + 1][j];
            }
          }

          // Loop for checking if string can itself found some pattern in it which could be
          // repeated.
          for (int k = 0; k < substr.length(); k++) {
            String repeatStr = substr.substring(0, k + 1);
            if (repeatStr != null
                && substr.length() % repeatStr.length() == 0
                && substr.replaceAll(repeatStr, "").length() == 0) {
              String ss = substr.length() / repeatStr.length() + "[" + dp[i][i + k] + "]";
              if (ss.length() < dp[i][j].length()) {
                dp[i][j] = ss;
              }
            }
          }
        }
      }
    }
    return dp[0][s.length() - 1];
  }
}
