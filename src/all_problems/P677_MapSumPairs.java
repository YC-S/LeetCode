package all_problems;

import java.util.HashMap;
import java.util.Map;

public class P677_MapSumPairs {
    Map<String, Integer> map;
    Map<String, Integer> original;

    public P677_MapSumPairs() {
        map = new HashMap<>();
        original = new HashMap<>();
    }

    public void insert(String key, int val) {
        val -= original.getOrDefault(key, 0); // calculate the diff to be added to prefixes
        String s = "";
        for (char c : key.toCharArray()) {
            s += c; // creating all prefixes
            map.put(s, map.getOrDefault(s, 0) + val); //update/insert all prefixes with new value
        }
        original.put(key, original.getOrDefault(key, 0) + val);
    }

    public int sum(String prefix) {
        return map.getOrDefault(prefix, 0);
    }
}
