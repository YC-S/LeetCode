package all_problems;

import java.util.HashMap;
import java.util.Map;

public class P356_LineReflection {
    public boolean isReflected(int[][] points) {
        int x_min = Integer.MAX_VALUE;
        int x_max = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap<>(); // 3 ms
        // Map<Integer, Integer> map = new TreeMap<>(); // 7 ms

        int length = points.length;
        for (int i = 0; i < length; i++) {
            // convert odd to even number - avoid (1+0)/2 = 0 situation
            points[i][0] = points[i][0] * 10;
            points[i][1] = points[i][1] * 10;

            int x = points[i][0];
            int y = points[i][1];

            // update x_min, x_max
            if (x < x_min) x_min = x;
            if (x > x_max) x_max = x;

            // store in hashmap
            int key = generate_key(x, y);
            map.put(key, key); // key hashed here
        }

        // warning: (0 + 1) / 2 = 0 -> correct: 1.5
        int x_mid = (x_min + x_max) / 2;

        // check it
        for (int i = 0; i < length; i++) {
            int x_one_side = points[i][0];
            int y = points[i][1];
            int x_other_side = x_mid + (x_mid - x_one_side);

            // check if in the same y, we can find the x_other_side
            int key = generate_key(x_other_side, y);
            Integer point = map.get(key);
            if (point == null) {
                return false;
            }
        }

        return true;

    }

    private int generate_key(int x, int y) {
        return x * 31 + y * 31 * 31;
    }
}
