package leetcode500.p06_string.plan4;

public class P125_ValidPalindrome {
  public boolean isPalindrome(String s) {
    s = s.toLowerCase();
    int i = 0, j = s.length() - 1;
    while (i < j) {
      while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
        i++;
      }
      while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
        j--;
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
