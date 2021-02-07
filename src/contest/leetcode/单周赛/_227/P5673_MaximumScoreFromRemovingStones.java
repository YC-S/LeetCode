package contest.leetcode.单周赛._227;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P5673_MaximumScoreFromRemovingStones {
    public int maximumScore(int a, int b, int c) {
        List<Integer> list = new ArrayList<>(3);
        list.add(a);
        list.add(b);
        list.add(c);
        Collections.sort(list);
        a = list.get(0);
        b = list.get(1);
        c = list.get(2);
        if (a + b > c) {
            return (a + b + c) / 2;
        } else if (a + b == c) {
            return c;
        } else {
            return a + b;
        }
    }
}
