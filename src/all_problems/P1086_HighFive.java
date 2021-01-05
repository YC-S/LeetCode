package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/18
 */
public class P1086_HighFive {

    public int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            PriorityQueue<Integer> pq;
            if (!map.containsKey(id)) {
                pq = new PriorityQueue<Integer>(5);
                pq.offer(score);
            } else {
                pq = map.get(id);
                pq.offer(score);
                if (pq.size() > 5) {
                    pq.poll();
                }
            }
            map.put(id, pq);
        }
        int index = 0;
        int[][] res = new int[map.size()][2];
        for (int id : map.keySet()) {
            res[index][0] = id;
            PriorityQueue<Integer> pq = map.get(id);
            int sum = 0;
            int size = pq.size();
            while (!pq.isEmpty()) {
                sum += pq.poll();
            }
            res[index][1] = sum / size;
            index++;
        }
        return res;
    }
}
