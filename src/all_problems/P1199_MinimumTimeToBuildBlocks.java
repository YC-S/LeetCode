package all_problems;

import java.util.PriorityQueue;

public class P1199_MinimumTimeToBuildBlocks {
    public int minBuildTime(int[] blocks, int split) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : blocks) pq.add(i);
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            pq.add(Math.max(x, y) + split);
        }
        return pq.poll();
    }
}
