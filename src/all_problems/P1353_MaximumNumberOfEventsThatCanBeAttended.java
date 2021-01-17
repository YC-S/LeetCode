package all_problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P1353_MaximumNumberOfEventsThatCanBeAttended {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, res = 0, n = events.length;
        for (int d = 1; d <= 100000; ++d) {
            while (!pq.isEmpty() && pq.peek() < d)
                pq.poll();
            while (i < n && events[i][0] == d)
                pq.offer(events[i++][1]);
            if (!pq.isEmpty()) {
                pq.poll();
                ++res;
            }
        }
        return res;
    }
}
