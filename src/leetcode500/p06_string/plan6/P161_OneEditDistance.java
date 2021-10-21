package leetcode500.p06_string.plan6;

public class P161_OneEditDistance {
  public boolean isOneEditDistance(String s, String t) {
    if (s == null && t == null) return true;
    if (s == null && t.length() == 1) return true;
    if (s.length() == 1 && t == null) return true;

    int m = s.length(), n = t.length();
    if (Math.abs(m - n) > 1) return false;
    if (m > n) {
      String tmp = s;
      s = t;
      t = tmp;
    }
    m = s.length();
    n = t.length();
    // insert or delete

    if (n - m == 1) {
      int i = 0, j = 0;
      while (i < m && j < n) {
        if (s.charAt(i) != t.charAt(j)) {
          break;
        } else {
          i++;
          j++;
        }
      }
      if (i == m) return true;
      j++;
      while (i < m && j < n) {
        if (s.charAt(i) != t.charAt(j)) {
          return false;
        } else {
          i++;
          j++;
        }
      }
      return true;
    }

    // replace

    if (m == n) {
      int diff = 0;
      for (int i = 0; i < m; i++) {
        if (s.charAt(i) != t.charAt(i)) {
          diff++;
        }
      }
      return diff == 1;
    }
    return false;
  }
}
