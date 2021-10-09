package leetcode500.p06_string.plan4;

public class P392_IsSubsequence {
  public boolean isSubsequence(String s, String t) {
    int i = 0, j = 0;
    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
      }
      j++;
    }
    return i == s.length();
  }
}
