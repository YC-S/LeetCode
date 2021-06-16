package all_problems;

public class P1901_FindAPeakElementII {
  public int[] findPeakGrid(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int l = 0;
    int r = m - 1;
    while (l <= r) {
      int mid = l + r >> 1;
      int idx = 0;
      for (int i = 0; i < n; i++) {
        if (mat[mid][i] > mat[mid][idx]) {
          idx = i;
        }
      }
      int up = mid > 0 ? mat[mid - 1][idx] : -1;
      int down = mid < m - 1 ? mat[mid + 1][idx] : -1;
      if (mat[mid][idx] > up && mat[mid][idx] > down) {
        return new int[] {mid, idx};
      } else if (mat[mid][idx] < up) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return null;
  }
}
