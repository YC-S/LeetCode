/*
 * Copyright (c) 2020. Yuanchen
 */

package may_challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @created 2020/05/06
 * @project LeetCode
 */
public class P6MajorityElement {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.getOrDefault(i, 0) >= (nums.length / 2)) {
                return i;
            }
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num = {3, 2, 3};
        int[] num1 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(num));
        System.out.println(majorityElement(num1));
    }
}
