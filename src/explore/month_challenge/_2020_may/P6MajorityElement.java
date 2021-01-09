/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_may;

/**
 * @author shiyuanchen
 * @created 2020/05/06
 * @project LeetCode
 */
public class P6MajorityElement {

    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] num = {3, 2, 3};
        int[] num1 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(num));
        System.out.println(majorityElement(num1));
    }
}
