/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.Random;
import java.util.TreeMap;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/11
 */
public class P528_RandomPickWithWeight {

    int count = 0;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    Random random = new Random();

    public P528_RandomPickWithWeight(int[] w) {
        for (int i = 0; i < w.length; i++) {
            count += w[i];
            map.put(count, i);
        }
    }

    public int pickIndex() {
        int key = map.higherKey(random.nextInt(count)); // higherKey(): the least key greater than key
        return map.get(key);
    }
}
