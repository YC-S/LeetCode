package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/18
 */
public class P56_MergeIntervals {

    // Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    // Output: [[1,6],[8,10],[15,18]]
    // Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; ++i) {
            int[] cur = intervals[i];
            if (prev[1] < cur[0]) {
                res.add(prev);
                prev = cur;
            } else {
                prev[1] = Math.max(prev[1], cur[1]);
            }
        }
        res.add(prev);
        int n = res.size();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
