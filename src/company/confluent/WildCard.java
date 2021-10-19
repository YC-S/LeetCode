package company.confluent;

public class WildCard {
  // build a 2d boolean matrix
  // dp[i][j] = isMatch(s.substring(i), p.substring(j))
  // dp[s.length() + 1][p.length() + 1] = true;

  // base case:
  // if both are empty , result should be true;

  // induction rule:
  // 4 case:
  // 1: s.charAt(i) == p.charAt(j)
  // 2: p.charAt(j) == *
  // 3: else

  public static boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[s.length()][p.length()] = true;
    for (int i = p.length() - 1; i >= 0; i--) {
      if (p.charAt(i) == '*') {
        dp[s.length()][i] = true;
      } else {
        break;
      }
    }
    for (int i = s.length() - 1; i >= 0; i--) {
      for (int j = p.length() - 1; j >= 0; j--) {
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
          dp[i][j] = dp[i + 1][j + 1];
        } else if (p.charAt(j) == '*') {
          dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
        } else {
          dp[i][j] = false;
        }
      }
    }
    return dp[0][0];
  }

  public static void main(String[] args) {
    System.out.println(isMatch("abcbdk", "*a*b?k"));
  }
}
