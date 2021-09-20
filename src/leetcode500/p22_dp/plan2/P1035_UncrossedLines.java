package leetcode500.p22_dp.plan2;

public class P1035_UncrossedLines {
  public int maxUncrossedLines(int[] nums1, int[] nums2) {
    int[][] dp = new int[2][nums2.length + 1];

    int flag = 1;
    for (int i = nums1.length - 1; i >= 0; i--) {
      for (int j = nums2.length - 1; j >= 0; j--) {
        dp[flag][j] =
            (nums1[i] == nums2[j]
                ? dp[flag ^ 1][j + 1] + 1
                : Math.max(dp[flag][j + 1], dp[flag ^ 1][j]));
      }
      flag ^= 1;
    }

    return dp[flag ^ 1][0];
  }
}
