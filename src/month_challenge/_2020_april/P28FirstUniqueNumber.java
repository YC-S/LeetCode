/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_april;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author shiyuanchen
 * @created 2020/04/28
 * @project LeetCode
 */
public class P28FirstUniqueNumber {

    Set<Integer> set;
    Set<Integer> all;

    public P28FirstUniqueNumber(int[] nums) {
        set = new LinkedHashSet<>();
        all = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!all.contains(nums[i])) {
                all.add(nums[i]);
                set.add(nums[i]);
            } else {
                set.remove(nums[i]);
            }
        }
    }

    public int showFirstUnique() {
        if (set.size() == 0) {
            return -1;
        }
        return set.iterator().next();
    }

    public void add(int value) {
        if (!all.contains(value)) {
            all.add(value);
            set.add(value);
        } else {
            set.remove(value);
        }
    }

}
