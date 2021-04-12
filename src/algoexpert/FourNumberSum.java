package algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourNumberSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        List<Integer[]> quad = new ArrayList<>();
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int cur = array[i] + array[j];
                int diff = targetSum - cur;
                if (map.containsKey(diff)) {
                    for (Integer[] pair : map.get(diff)) {
                        quad.add(new Integer[]{pair[0], pair[1], array[i], array[j]});
                    }
                }
            }
            for (int k = 0; k < i; k++) {
                int cur = array[i] + array[k];
                Integer[] pair = {array[k], array[i]};
                if (!map.containsKey(cur)) {
                    List<Integer[]> pairGroup = new ArrayList<>();
                    pairGroup.add(pair);
                    map.put(cur, pairGroup);
                } else {
                    map.get(cur).add(pair);
                }
            }
        }
        return quad;
    }
}
