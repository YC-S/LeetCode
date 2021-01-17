package all_problems;

import java.util.HashMap;
import java.util.Map;

public class P1726_TupleWithSameProduct {
    public int tupleSameProduct(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans += 8 * map.getOrDefault(nums[i] * nums[j], 0);
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }

        return ans;
    }
}
