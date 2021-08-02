package laicode.dpIV;

public class LongestCommonSubsequence {
  public int longest(String source, String target) {
    int[][] longest = new int[source.length() + 1][target.length() + 1];
    for (int i = 1; i <= source.length(); i++) {
      for (int j = 1; j <= target.length(); j++) {
        if (source.charAt(i - 1) == target.charAt(j - 1)) {
          longest[i][j] = longest[i - 1][j - 1] + 1;
        } else {
          longest[i][j] = Math.max(longest[i - 1][j], longest[i][j - 1]);
        }
      }
    }
    return longest[source.length()][target.length()];
  }
}
