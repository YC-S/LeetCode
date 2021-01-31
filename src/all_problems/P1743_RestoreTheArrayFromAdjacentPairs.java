package all_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1743_RestoreTheArrayFromAdjacentPairs {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        int[] ans = new int[n];
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] pair : adjacentPairs) { // Loop through the input and build the corresponding graph.
            adj.computeIfAbsent(pair[0], s -> new HashSet<>()).add(pair[1]);
            adj.computeIfAbsent(pair[1], s -> new HashSet<>()).add(pair[0]);
        }
        int prev = 1 << 31, cur = -1, k = 0; // prev and cur are initialized as dummy values.
        for (Map.Entry<Integer, Set<Integer>> e : adj.entrySet()) {
            if (e.getValue().size() == 1) { // locate an end.
                cur = e.getKey();
                break;
            }
        }
        ans[k++] = cur; // start from the end.
        while (k < n) {
            for (int next : adj.remove(cur)) { // locate the corresponding pair.
                if (k < n && next != prev) {
                    ans[k++] = next;
                    prev = cur; // move to next element.
                    cur = next; // move to next element.
                    break;
                }
            }
        }
        return ans;
    }
}
