/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/19
 */
public class Climb {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int i : ranked) {
            pq.add(i);
        }
        List<Integer> res = new ArrayList<>();
        for (int p : player) {
            check(res, pq, p);
        }
        return res;
    }

    private static void check(List<Integer> res, PriorityQueue<Integer> pq, int p) {
        int rank = 1;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(pq);
        int prev = pq1.poll();
        if (prev <= p) {
            res.add(1);
        } else {
            pq1.add(prev);
            pq1.add(p);
            while (pq1.peek() != p) {
                if (prev != pq1.peek()) {
                    rank++;
                    prev = pq1.peek();
                }
                pq1.poll();
            }
            res.add(rank + 1);
        }
        pq.add(p);
    }

    public static void main(String[] args) {
        System.out
            .println(climbingLeaderboard(Arrays.asList(100, 100, 50, 40, 40, 20, 10), Arrays.asList(5, 25, 50, 120)));
    }
}
