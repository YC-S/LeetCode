package all_problems;

import java.util.Arrays;

public class P1288_RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        int res = 0, left = -1, right = -1;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int[] v : intervals) {
            if (v[0] > left && v[1] > right) {
                left = v[0];
                ++res;
            }
            right = Math.max(right, v[1]);
        }
        return res;
    }
}
