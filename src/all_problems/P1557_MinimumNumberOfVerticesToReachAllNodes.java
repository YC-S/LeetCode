package all_problems;

import java.util.ArrayList;
import java.util.List;

public class P1557_MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        int[] seen = new int[n];
        for (List<Integer> e : edges)
            seen[e.get(1)] = 1;
        for (int i = 0; i < n; ++i)
            if (seen[i] == 0)
                res.add(i);
        return res;
    }
}
