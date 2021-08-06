package leetcode500.p02_binary_search.plan1;

public class P278_FirstBadVersion {
  public static int firstBadVersion(int n) {
    int left = 1, right = n;
    while (left < right - 1) {
      int mid = (left + right) >>> 1;
      if (isBadVersion(mid)) right = mid;
      else left = mid + 1;
    }
    return isBadVersion(left) ? left : right;
  }

  private static boolean isBadVersion(int version) {
    return version == 1;
  }

  public static void main(String[] args) {
    System.out.println(firstBadVersion(1));
  }
}
