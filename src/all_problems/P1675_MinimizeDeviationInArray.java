package all_problems;

import java.util.PriorityQueue;

public class P1675_MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int n = nums.length, mi = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for (int a : nums) {
            if (a % 2 == 1) a *= 2;
            pq.add(-a);
            mi = Math.min(mi, a);
        }
        while (true) {
            int a = -pq.poll();
            res = Math.min(res, a - mi);
            if (a % 2 == 1) break;
            mi = Math.min(mi, a / 2);
            pq.add(-a / 2);
        }
        return res;
    }
}
