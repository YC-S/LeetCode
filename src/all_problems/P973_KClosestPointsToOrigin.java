package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/19
 */
public class P973_KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (a, b) -> {
            return a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1];
        });
        int[][] res = new int[K][2];
        for (int i = 0; i < K; ++i) {
            res[i] = points[i];
        }
        return res;
    }
}
