package all_problems;

public class P1828_QueriesOnNumberOfPointsInsideACircle {
  public int[] countPoints(int[][] points, int[][] queries) {
    int n = queries.length;
    int[] ans = new int[n];
    for (int i = 0; i < n; ++i) {
      int x = queries[i][0], y = queries[i][1], r2 = queries[i][2] * queries[i][2];
      for (int[] p : points) {
        ans[i] += (p[0] - x) * (p[0] - x) + (p[1] - y) * (p[1] - y) <= r2 ? 1 : 0;
      }
    }
    return ans;
  }
}
