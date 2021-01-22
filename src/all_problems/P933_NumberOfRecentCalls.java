package all_problems;

import java.util.TreeSet;

public class P933_NumberOfRecentCalls {
    TreeSet<Integer> ts;

    public P933_NumberOfRecentCalls() {
        ts = new TreeSet<>();
    }

    public int ping(int t) {
        ts.add(t);
        return ts.tailSet(t - 3000).size();
    }
}
