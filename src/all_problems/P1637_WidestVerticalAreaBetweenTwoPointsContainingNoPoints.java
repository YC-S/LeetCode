package all_problems;

import java.util.Arrays;
import java.util.Comparator;

public class P1637_WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        int mx = 0;
        for (int i = 1; i < points.length; ++i) {
            mx = Math.max(mx, points[i][0] - points[i - 1][0]);
        }
        return mx;
    }
}
