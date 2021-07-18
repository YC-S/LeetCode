package contest.leetcode.单周赛._250;

public class MaxPoints {
  public static long maxPoints(int[][] points) {
    int res = 0;
    int[] col = new int[points.length];
    int[] dp = new int[points.length];
    int max = points[0][0];
    int col1 = 0;
    for (int i = 1; i < points[0].length; i++) {
      if (points[0][i] > max) {
        max = points[0][i];
        col1 = i;
      } else if (points[0][i] == max) {
        int j = 1;
        while (j < points.length) {
          if (points[j][i] > points[j][col1]) {
            col1 = i;
            break;
          } else if (points[j][col1] > points[j][i]) {
            break;
          }
          j++;
        }
      }
    }
    dp[0] = max;
    col[0] = col1;
    res += max;

    for (int i = 1; i < points.length; i++) {
      int curMax = points[i][0] - Math.abs(0 - col[i - 1]);
      int curCol = 0;
      for (int j = 1; j < points[0].length; j++) {
        if (points[i][j] - Math.abs(j - col[i - 1]) > curMax) {
          curMax = points[i][j] - Math.abs(j - col[i - 1]);
          curCol = j;
        }
      }
      res += curMax;
      col[i] = curCol;
    }
    return res;
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
