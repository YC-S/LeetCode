package all_problems;

public class P1855_MaximumDistanceBetweenAPairOfValues {
  public int maxDistance(int[] nums1, int[] nums2) {
    int res = 0, i = 0, n = nums1.length, m = nums2.length;
    for (int j = 0; j < m; j++) {
      while (i < n && nums1[i] > nums2[j]) {
        i++;
      }
      if (i == n) break;
      res = Math.max(res, j - i);
    }
    return res;
  }
}
