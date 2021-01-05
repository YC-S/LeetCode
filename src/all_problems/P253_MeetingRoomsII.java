package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/14
 */
public class P253_MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1, o2) -> {
                return o1[1] - o2[1];
            }
        );
        for (int[] interval : intervals) {
            if (pq.isEmpty()) {
                pq.offer(interval);
            } else if (pq.peek()[1] <= interval[0]) {
                int[] tmp = pq.poll();
                tmp[1] = interval[1];
                pq.offer(tmp);
            } else {
                pq.offer(interval);
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        int[][] intervals = {{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}};
        System.out.println(minMeetingRooms(intervals));
    }
}
