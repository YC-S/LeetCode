package leetcode500.p23_dp_string_match.plan2;

public class P647_PalindromicSubstrings {
  int count = 0;

  public int countSubstrings(String s) {
    if (s == null || s.length() == 0) return 0;
    for (int i = 0; i < s.length(); i++) { // i is the mid point
      checkPalindrome(s, i, i); // odd length;
      checkPalindrome(s, i, i + 1); // even length
    }
    return count;
  }

  private void checkPalindrome(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      count++;
      left--;
      right++;
    }
  }
}
