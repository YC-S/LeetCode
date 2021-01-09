package all_problems;

import java.util.ArrayList;
import java.util.List;

public class P1560_MostVisitedSectorInACircularTrack {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new ArrayList<>();
        for (int i = rounds[0]; i <= rounds[rounds.length - 1]; ++i)
            res.add(i);
        if (res.size() > 0) return res;
        for (int i = 1; i <= rounds[rounds.length - 1]; ++i)
            res.add(i);
        for (int i = rounds[0]; i <= n; ++i)
            res.add(i);
        return res;
    }
}
