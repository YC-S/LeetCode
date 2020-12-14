/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/11
 */
public class P465_OptimalAccountBalancing {

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions) {
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) - transaction[2]);
            map.put(transaction[1], map.getOrDefault(transaction[1], 0) + transaction[2]);
        }
        return dfs(0, new ArrayList<>(map.values()));
    }

    private int dfs(int index, List<Integer> list) {
        if (index == list.size()) {
            return 0;
        }
        // skip 0
        if (list.get(index) == 0) {
            return dfs(index + 1, list);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = index + 1; i < list.size(); i++) {
            if (list.get(i) * list.get(index) > 0) {
                continue;
            }
            list.set(i, list.get(i) + list.get(index));
            ans = Math.min(ans, 1 + dfs(index + 1, list));
            list.set(i, list.get(i) - list.get(index));
            // list.get(i) and list.get(index)'s throughput is 0, they're the best matched, stop brute force
            // must recover list before break and return current optimal answer since upper layer may reuse list
            if (list.get(i) + list.get(index) == 0) {
                break;
            }
        }
        return ans;
    }
}
