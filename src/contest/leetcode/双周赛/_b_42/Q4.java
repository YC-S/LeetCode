package contest.leetcode.双周赛._b_42;

import java.util.ArrayList;

public class Q4 {
    public int minMoves(int[] nums, int k) {
        ArrayList<Long> A = new ArrayList<Long>(), B = new ArrayList<Long>();
        for (int i = 0; i < nums.length; ++i)
            if (nums[i] == 1)
                A.add((long) i);
        long res = Long.MAX_VALUE;
        B.add(0L);
        for (int i = 0; i < A.size(); ++i)
            B.add(B.get(i) + A.get(i));
        for (int i = 0; i < A.size() - k + 1; ++i)
            res = Math.min(res, B.get(i + k) - B.get(k / 2 + i) - B.get((k + 1) / 2 + i) + B.get(i));
        res -= (long) (k / 2) * ((k + 1) / 2);
        return (int) res;
    }
}
