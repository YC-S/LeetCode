package contest.leetcode.单周赛._250;

public class MaxPoints {
  public static long maxPoints(int[][] points) {
    long ans = 0;
    int m = points.length, n = points[0].length;
    long[] dp = new long[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dp[j] += points[i][j];
      }
      for (int j = 1; j < n; j++) {
        dp[j] = Math.max(dp[j], dp[j - 1] - 1);
      }
      for (int j = n - 2; j >= 0; j--) {
        dp[j] = Math.max(dp[j], dp[j + 1] - 1);
      }
    }
    for (int i = 0; i < n; i++) {
      ans = Math.max(ans, dp[i]);
    }
    return ans;
  }

  public static void main(String[] args) {
    //    int[][] points =
    //        new int[][] {{2, 4, 0, 5, 5}, {0, 5, 4, 2, 5}, {2, 0, 2, 3, 1}, {3, 0, 5, 5, 2}};
    int[][] points1 = new int[][] {{0, 0}, {5, 3}, {2, 3}, {3, 3}};
    int[][] points2 =
        new int[][] {{1, 2, 4, 4, 3}, {1, 4, 5, 5, 1}, {5, 2, 3, 5, 5}, {2, 3, 4, 3, 0}};
    //    System.out.println(maxPoints(points));
    System.out.println(maxPoints(points1));
    System.out.println(maxPoints(points2));
  }
}
