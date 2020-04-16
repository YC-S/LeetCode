/*
 * Copyright (c) 2020. Yuanchen
 */

package p30daychallenge;


import java.util.Arrays;

/**
 * @author shiyuanchen
 */
public class P15ProductExceptSelf {

    public static int[] productExcepSelf(int[] nums) {
//        method1
//        int[] res = new int[nums.length];
//        int n = nums.length;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            if (map.containsKey(nums[i])) {
//                res[i] = map.get(nums[i]);
//            } else {
//                res[i] = 1;
//                for (int j = 0; j < n; j++) {
//                    if (i != j) {
//                        res[i] *= nums[j];
//                    }
//                }
//                map.put(nums[i], res[i]);
//            }
//        }
//
//        return res;
        int n = nums.length;
        int[] l = new int[n];
        l[0] = 1;
        for (int i = 1; i < n; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = n - 1; i >= 0; i--) {
            l[i] = l[i] * r;
            r *= nums[i];
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExcepSelf(nums)));
    }
}
