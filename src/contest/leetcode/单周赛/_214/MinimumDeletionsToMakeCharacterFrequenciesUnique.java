package contest.leetcode.单周赛._214;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (char c : map.keySet()) {
            int t = map.get(c);
            while (set.contains(t)) {
                t--;
                res++;
            }
            if (t != 0) {
                set.add(t);
            }
        }
        return res;
    }
}
