package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/10
 */
public class P403_FrogJump {

    /**
     * key is the stone position value is a set containing jump size which can jump to the stone position
     * <p>
     * Then traverse each position , check if current position + new jump size exists in the map.
     * <p>
     * The idea is to keep maintain the no of possible k for each stone .Traverse through all possible k values to
     * make sure you are not missing any possibility .if there is at least one K at the last stone then the answer
     * is true.
     * <p>
     * [0,1,3,5,6,8,12,17]
     * <p>
     * For the above example data structure looks like below .It returns true because it could reach last stone with k=5
     * ---------
     * |Map:Set  |
     * |---------|
     * |0  :0    |
     * |1  :1    |
     * |3  :2    |
     * |5  :2    |
     * |6  :3 1  |
     * |8  :3 2 2|
     * |12 :4    |
     * |17 :5    |
     * ---------
     * <p>
     * [0,1,2,3,4,8,9,11]
     * <p>
     * <p>
     * For the above example data structure looks like below .It returns false because there is no K at the last element .
     * --------
     * |Map:Set  |
     * ---------
     * |0 :0     |
     * |1 :1     |
     * |2 :1     |
     * |3 :2 1   |
     * |4 :2 1 1 |
     * |8 :      |
     * |9 :      |
     * |11:      |
     * --------
     */


    public boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(stones[i], new HashSet<>());
        map.get(0).add(0);
        for (int i = 0; i < n; i++) {
            for (int k : map.get(stones[i])) {
                if (k - 1 > 0 && map.containsKey(k - 1 + stones[i])) map.get(k - 1 + stones[i]).add(k - 1);
                if (k > 0 && map.containsKey(k + stones[i])) map.get(k + stones[i]).add(k);
                if (k + 1 > 0 && map.containsKey(k + 1 + stones[i])) map.get(k + 1 + stones[i]).add(k + 1);
            }
        }
        return map.get(stones[n - 1]).size() > 0;
    }
}
