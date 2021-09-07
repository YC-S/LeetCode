package leetcode500.p35_geometry.plan1;

public class P593_ValidSquare {
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    double d12 = squareDistance(p1, p2);
    double d13 = squareDistance(p1, p3);
    double d14 = squareDistance(p1, p4);
    double d42 = squareDistance(p4, p2);
    double d43 = squareDistance(p4, p3);
    double d32 = squareDistance(p3, p2);

    if (d12 == 0 || d13 == 0 || d14 == 0 || d42 == 0 || d43 == 0 || d32 == 0) return false;
    if (d12 == d13) {
      return (d42 == d43 && 2 * d42 == d14);
    } else if (d12 == d14) {
      return (d32 == d43 && 2 * d32 == d13);
    } else if (d13 == d14) {
      return (d32 == d42 && 2 * d32 == d12);
    }
    return false;
  }

  public double squareDistance(int[] p1, int[] p2) {
    return Math.pow((p1[0] - p2[0]), 2) + Math.pow((p1[1] - p2[1]), 2);
  }
}
