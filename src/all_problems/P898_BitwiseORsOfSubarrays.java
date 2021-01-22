package all_problems;

import java.util.HashSet;
import java.util.Set;

public class P898_BitwiseORsOfSubarrays {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>(), cur = new HashSet<>(), cur2;
        for (Integer i : arr) {
            cur2 = new HashSet<>();
            cur2.add(i);
            for (Integer j : cur) cur2.add(i | j);
            res.addAll(cur = cur2);
        }
        return res.size();
    }
}
