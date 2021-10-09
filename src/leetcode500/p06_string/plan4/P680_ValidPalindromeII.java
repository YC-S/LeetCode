package leetcode500.p06_string.plan4;

public class P680_ValidPalindromeII {
  public boolean validPalindrome(String s) {
    int i = 0, j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
      } else {
        for (int k = i; k <= j; k++) {
          if (isValid(s, i, j, k)) {
            return true;
          }
        }
        return false;
      }
    }
    return true;
  }

  private boolean isValid(String s, int i, int j, int k) {
    while (i < j) {
      if (i == k) {
        i++;
        continue;
      }
      if (j == k) {
        j--;
        continue;
      }
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
      } else {
        return false;
      }
    }
    return true;
  }
}
