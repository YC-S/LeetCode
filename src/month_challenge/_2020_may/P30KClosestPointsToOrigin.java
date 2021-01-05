/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_may;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/05/30
 */
public class P30KClosestPointsToOrigin {

  public int[][] kClosest(int[][] points, int K) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(
      Comparator.comparingInt(this::distance2));
    Collections.addAll(pq, points);
    int[][] res = new int[K][];
    for (int i = 0; i < K; i++) {
      res[i] = pq.poll();
    }
    return res;
  }

  private int distance2(int[] point) {
    return (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
  }
}
