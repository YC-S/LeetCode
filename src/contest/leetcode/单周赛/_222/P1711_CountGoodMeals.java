package contest.leetcode.单周赛._222;

import java.util.HashMap;
import java.util.Map;

public class P1711_CountGoodMeals {
    int mod = 1000000007;
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = deliciousness.length;
        long res = 0;
        for (int num : deliciousness) {
            int power = 1;
            for (int i = 0; i < 22; i++) {
                if (map.containsKey(power - num)) {
                    res += map.get(power - num);
                    res %= mod;
                }
                power *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return (int) res;
    }
}
