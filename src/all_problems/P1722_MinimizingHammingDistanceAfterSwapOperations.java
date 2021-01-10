package all_problems;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class P1722_MinimizingHammingDistanceAfterSwapOperations {
    public int find(int n, int[] parent) {
        if (parent[n] == n)
            return n;
        return (parent[n] = find(parent[n], parent));
    }

    public int minimumHammingDistance(int[] arr, int[] target, int[][] allowedSwaps) {
        int n = target.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] swap : allowedSwaps) {
            int a = swap[0], b = swap[1];
            parent[find(a, parent)] = find(b, parent);
        }
        Set<Integer> sets = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            parent[i] = find(i, parent);
            sets.add(parent[i]);
        }
        Map<Integer, Map<Integer, Integer>> setMap = new LinkedHashMap<>();
        for (int set : sets) {
            setMap.put(set, new LinkedHashMap<>());
        }
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> valueMap = setMap.get(parent[i]);
            valueMap.put(arr[i], valueMap.getOrDefault(arr[i], 0) + 1);
        }
        int distance = n;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> valueMap = setMap.get(parent[i]);
            if (valueMap.containsKey(target[i])) {
                valueMap.put(target[i], valueMap.get(target[i]) - 1);
                if (valueMap.get(target[i]) == 0) {
                    valueMap.remove(target[i]);
                }
                distance--;
            }
        }
        return distance;
    }
}
