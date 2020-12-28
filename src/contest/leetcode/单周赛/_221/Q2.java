package contest.leetcode.单周赛._221;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2 {
    public static int eatenApples(int[] apples, int[] days) {
        int max = 0;
        int n = apples.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, i + 1 + days[i]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int res = 0;
        for (int i = 0; i < max; i++) {
            while (!pq.isEmpty() && pq.peek()[1] <= i) {
                pq.poll();
            }
            if (i < n && apples[i] != 0) {
                pq.offer(new int[]{apples[i], i + days[i], i});
            }
            if (!pq.isEmpty()) {
                res++;
                int[] cur = pq.poll();
                if (cur[0] - 1 != 0) {
                    pq.offer(new int[]{cur[0] - 1, cur[1], cur[2]});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] apples = {9, 10, 1, 7, 0, 2, 1, 4, 1, 7, 0, 11, 0, 11, 0, 0, 9, 11, 11, 2, 0, 5, 5};
        int[] days = {3, 19, 1, 14, 0, 4, 1, 8, 2, 7, 0, 13, 0, 13, 0, 0, 2, 2, 13, 1, 0, 3, 7};
//        int[] apples = {1,2,3,5,2};
//        int[] days = {3,2,1,4,2};
        System.out.println(eatenApples(apples, days));
    }
}
