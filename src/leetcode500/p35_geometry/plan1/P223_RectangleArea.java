package leetcode500.p35_geometry.plan1;

public class P223_RectangleArea {
  public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
    int tmp = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
    if (ax2 < bx1 || bx2 < ax1) {
      return tmp;
    }
    if (ay1 > by2 || by1 > ay2) {
      return tmp;
    }
    int overlap =
        (Math.min(ax2, bx2) - Math.max(bx1, ax1)) * (Math.min(ay2, by2) - Math.max(ay1, by1));
    return tmp - overlap;
  }
}
