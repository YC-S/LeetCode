package all_problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class P1724_CheckingExistenceOfEdgeLengthLimitedPathII {
    TreeMap<Integer, int[]> map;

    public P1724_CheckingExistenceOfEdgeLengthLimitedPathII(int n, int[][] edgeList) {
        map = new TreeMap<>();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        Arrays.stream(edgeList).forEach(edge -> pq.add(edge));
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int n1 = curr[0];
            int n2 = curr[1];
            int weight = curr[2];
            union(parent, n1, n2);
            map.put(weight, parent.clone());
        }
    }

    public boolean query(int p, int q, int limit) {
        Integer lower = map.lowerKey(limit);
        if (lower == null) {
            return false;
        }
        int[] parent = map.get(lower);
        return find(parent, p) == find(parent, q);
    }

    public int find(int[] parent, int n) {
        if (parent[n] == n) {
            return n;
        }
        parent[n] = find(parent, parent[n]);
        return parent[n];
    }

    public void union(int[] parent, int a, int b) {
        int parentA = find(parent, a);
        int parentB = find(parent, b);
        parent[parentB] = parentA;
    }
}
