package all_problems;

import java.util.LinkedList;
import java.util.List;

public class P1627_GraphConnectivityWithThreshold {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> res = new LinkedList<>();
        int[] map = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            map[i] = i;
        }

        for (int i = threshold + 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                map[find(map, j)] = find(map, i);
            }
        }

        for (int[] query : queries) {
            res.add(find(map, query[0]) == find(map, query[1]));
        }
        return res;
    }

    public int find(int[] map, int id) {
        while (map[id] != id) {
            map[id] = map[map[id]];
            id = map[id];
        }
        return id;
    }
}
