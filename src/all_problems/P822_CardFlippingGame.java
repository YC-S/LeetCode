package all_problems;

import java.util.HashSet;

public class P822_CardFlippingGame {
    public int flipgame(int[] fronts, int[] backs) {
        HashSet<Integer> same = new HashSet<>();
        for (int i = 0; i < fronts.length; ++i) if (fronts[i] == backs[i]) same.add(fronts[i]);
        int res = 3000;
        for (int i : fronts) if (!same.contains(i)) res = Math.min(res, i);
        for (int i : backs) if (!same.contains(i)) res = Math.min(res, i);
        return res % 3000;
    }
}
