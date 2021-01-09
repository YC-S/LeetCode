package all_problems;

import java.util.HashMap;
import java.util.Map;

public class P1546_MaximumNumberOfNonOverlappingsubarraysWithSumEqualsTarget {
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, availableIdx = -1, res = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remain = prefixSum - target;
            if (map.containsKey(remain) && map.get(remain) >= availableIdx) {
                res++;
                availableIdx = i;
            }
            map.put(prefixSum, i);
        }
        return res;
    }
}
