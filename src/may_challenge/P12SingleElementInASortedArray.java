/*
 * Copyright (c) 2020. Yuanchen
 */

package may_challenge;

/**
 * @author shiyuanchen
 * @created 2020/05/12
 * @project LeetCode
 */
public class P12SingleElementInASortedArray {

    public static int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(
            new int[]{1, 1, 2, 3, 3, 4, 4, 7, 7, 8, 8}));
    }
}
