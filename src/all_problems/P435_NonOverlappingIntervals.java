package all_problems;

import java.util.Arrays;

public class P435_NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int prev = intervals[0][1];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (prev > intervals[i][0]) {
                count++;
            } else {
                prev = intervals[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}}));
    }
}
