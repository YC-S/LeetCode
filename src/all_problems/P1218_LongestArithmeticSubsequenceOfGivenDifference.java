package all_problems;

import java.util.HashMap;
import java.util.Map;

public class P1218_LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr)
            ans = Math.max(ans, count.compute(a, (k, v) -> 1 + count.getOrDefault(a - difference, 0)));
        return ans;
    }
}
