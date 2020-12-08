/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.企业真题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/04
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] numbers = {3, 2, 4};
        System.out.println(Arrays.toString(new TwoSum().twoSum(numbers, 6)));
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; ++i) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{i, map.get(target - numbers[i])};
            } else {
                map.put(numbers[i], i);
            }
        }
        return new int[]{-1, -1};
    }

}
