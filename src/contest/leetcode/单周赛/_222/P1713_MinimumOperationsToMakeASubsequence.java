package contest.leetcode.单周赛._222;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class P1713_MinimumOperationsToMakeASubsequence {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < target.length; ++i)
            h.put(target[i], i);
        ArrayList<Integer> stack = new ArrayList<>();
        for (int a : arr) {
            if (!h.containsKey(a)) continue;
            if (stack.size() == 0 || h.get(a) > stack.get(stack.size() - 1)) {
                stack.add(h.get(a));
                continue;
            }
            int left = 0, right = stack.size() - 1, mid;
            while (left < right) {
                mid = (left + right) / 2;
                if (stack.get(mid) < h.get(a))
                    left = mid + 1;
                else
                    right = mid;
            }
            stack.set(left, h.get(a));
        }
        return target.length - stack.size();
    }
}
