package book.epi_java.chapter11;

import java.util.List;

public class BSearch {
  public static int search(int t, List<Integer> A) {
    int l = 0, r = A.size() - 1;
    while (l <= r) {
      int m = l + (r - l) / 2;
      if (A.get(m) < t) {
        l = m + 1;
      } else if (A.get(m) == t) {
        return m;
      } else {
        r = m - 1;
      }
    }
    return -1;
  }
}
