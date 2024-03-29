package leetcode500.p23_dp_string_match.plan2;

public class P5_LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    if (s == null || s.length() < 2) return s;
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int l = Math.max(expand(s, i, i), expand(s, i, i + 1));
      if (l > end - start) {
        start = i - (l - 1) / 2;
        end = i + l / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  private int expand(String s, int l, int r) {
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }
    return r - l - 1;
  }
}
