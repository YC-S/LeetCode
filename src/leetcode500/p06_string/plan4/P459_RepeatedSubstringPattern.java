package leetcode500.p06_string.plan4;

public class P459_RepeatedSubstringPattern {
  public boolean repeatedSubstringPattern(String s) {
    int n = s.length();
    for (int i = n / 2; i >= 1; i--) {
      int m = n / i;
      if (m * i == n) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < m; j++) {
          sb.append(s, 0, i);
        }
        if (sb.toString().equals(s)) return true;
      }
    }
    return false;
  }
}
