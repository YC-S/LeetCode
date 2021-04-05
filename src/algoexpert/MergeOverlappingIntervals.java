package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > list.get(list.size() - 1)[1]) {
                list.add(intervals[i]);
            } else {
                list.set(list.size() - 1, new int[]{list.get(list.size() - 1)[0], Math.max(intervals[i][1], list.get(list.size() - 1)[1])});
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 22}, {-20, 30}};
        int[][] res = mergeOverlappingIntervals(array);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }
}
