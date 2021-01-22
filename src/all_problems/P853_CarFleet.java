package all_problems;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class P853_CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> m = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < position.length; ++i)
            m.put(position[i], (double) (target - position[i]) / speed[i]);
        int res = 0;
        double cur = 0;
        for (double time : m.values()) {
            if (time > cur) {
                cur = time;
                res++;
            }
        }
        return res;
    }
}
