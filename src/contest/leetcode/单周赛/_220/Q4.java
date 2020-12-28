/*
 * Copyright (c) 2020. Yuanchen
 */

package contest.leetcode.单周赛._220;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/19
 */
public class Q4 {

    int[] parent;

    private int find(int i) {
        if (i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    private void union(int i, int j) {
        parent[find(i)] = find(j);
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        for (int i = 0; i < queries.length; i++) {
            queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
        Arrays.sort(queries, (a, b) -> a[2] - b[2]);
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0, j = 0; i < queries.length; i++) {
            while (j < edgeList.length && edgeList[j][2] < queries[i][2]) {
                union(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            res[queries[i][3]] = find(queries[i][0]) == find(queries[i][1]);
        }
        return res;
    }
}
