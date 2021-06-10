package all_problems;

public class P1891_CuttingRibbons {
  public int maxLength(int[] ribbons, int k) {
    int l = 1;
    int r = (int) 1e5 + 1;
    while (l < r) {
      int mid = l + ((r - l) >> 1);
      if (!isCutPossible(ribbons, mid, k)) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l - 1;
  }

  private boolean isCutPossible(int[] ribbons, int length, int k) {
    int count = 0;
    for (int ribbon : ribbons) {
      count += (ribbon / length);
    }
    return count >= k;
  }
}
