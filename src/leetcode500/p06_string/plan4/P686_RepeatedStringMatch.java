package leetcode500.p06_string.plan4;

public class P686_RepeatedStringMatch {
  public int repeatedStringMatch(String a, String b) {
    if (a.contains(b)) return 1;
    int m = a.length(), n = b.length();
    int times = n / m;
    StringBuilder sb = new StringBuilder(a);

    for (int i = 2; i <= times + 2; i++) {
      sb.append(a);
      if (sb.toString().contains(b)) {
        return i;
      }
    }
    return -1;
  }
}
