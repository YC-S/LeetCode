import java.util.Arrays;

public class P452_MinimumNumberOfArrowsToBurstBalloons {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] < o2[1]) {
                return -1;
            } else if (o1[1] == o2[1]) {
                return 0;
            } else {
                return 1;
            }
        });
        int arrows = 1;
        int start, end, prevEnd = points[0][1];
        for (int[] p : points) {
            start = p[0];
            end = p[1];
            if (prevEnd < start) {
                arrows++;
                prevEnd = end;
            }
        }
        return arrows;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(findMinArrowShots(points));
    }
}
