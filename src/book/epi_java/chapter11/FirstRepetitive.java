package book.epi_java.chapter11;

import java.util.Arrays;
import java.util.List;

public class FirstRepetitive {
  public static int search(int t, List<Integer> A) {
    if (A == null || A.size() == 0) return -1;
    int l = 0, r = A.size() - 1;
    while (l < r - 1) {
      int m = l + (r - l) / 2;
      if (A.get(m) >= t) {
        r = m;
      } else {
        l = m;
      }
    }
    if (A.get(l) == t) return l;
    else if (A.get(r) == t) return r;
    return -1;
  }

  public static void main(String[] args) {
    List<Integer> A = Arrays.asList(-14, -10, 2, 108, 108, 243, 285, 285, 285, 401);
    System.out.println(search(108, A));
    System.out.println(search(285, A));
  }
}
