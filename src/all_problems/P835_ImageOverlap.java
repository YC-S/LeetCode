package all_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P835_ImageOverlap {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int N = img1.length;
        List<Integer> LA = new ArrayList<>(), LB = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < N * N; ++i)
            if (img1[i / N][i % N] == 1)
                LA.add(i / N * 100 + i % N);
        for (int i = 0; i < N * N; ++i)
            if (img2[i / N][i % N] == 1)
                LB.add(i / N * 100 + i % N);
        for (int i : LA)
            for (int j : LB)
                count.put(i - j, count.getOrDefault(i - j, 0) + 1);
        int res = 0;
        for (int i : count.values())
            res = Math.max(res, i);
        return res;
    }
}
