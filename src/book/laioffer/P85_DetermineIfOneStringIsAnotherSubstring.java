package book.laioffer;

public class P85_DetermineIfOneStringIsAnotherSubstring {
  public static void main(String[] args) {}

  public int strstr(String large, String small) {
    if (large.length() < small.length()) return -1;
    if (small.length() == 0) return 0;
    for (int i = 0; i <= large.length() - small.length(); i++) {
      if (equals(large, small, i)) {
        return i;
      }
    }
    return -1;
  }

  private boolean equals(String large, String small, int start) {
    for (int i = 0; i < small.length(); i++) {
      if (small.charAt(i) != large.charAt(start + i)) {
        return false;
      }
    }
    return true;
  }
}
