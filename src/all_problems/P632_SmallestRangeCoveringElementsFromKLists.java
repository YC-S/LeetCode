package all_problems;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P632_SmallestRangeCoveringElementsFromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> nums.get(o[0]).get(o[1])));
        int max = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            q.offer(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        while (q.size() == nums.size()) {
            int[] e = q.poll();
            int row = e[0];
            int col = e[1];
            if (end - start > max - nums.get(row).get(col)) {
                start = nums.get(row).get(col);
                end = max;
            }
            if (col + 1 < nums.get(row).size()) {
                q.offer(new int[]{row, col + 1});
                max = Math.max(max, nums.get(row).get(col + 1));
            }
        }
        return new int[]{start, end};
    }
}
