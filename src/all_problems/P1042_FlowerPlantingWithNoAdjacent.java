package all_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1042_FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new HashSet<>());
        for (int[] p : paths) {
            map.get(p[0] - 1).add(p[1] - 1);
            map.get(p[1] - 1).add(p[0] - 1);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int[] colors = new int[5];
            for (int j : map.get(i))
                colors[res[j]] = 1;
            for (int c = 4; c > 0; --c)
                if (colors[c] == 0)
                    res[i] = c;
        }
        return res;
    }
}
