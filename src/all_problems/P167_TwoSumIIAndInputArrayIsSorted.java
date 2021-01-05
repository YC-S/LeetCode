package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/12
 */
public class P167_TwoSumIIAndInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int[] array = new int[2];
        if (numbers == null || numbers.length < 2) {
            return array;
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int v = numbers[left] + numbers[right];
            if (v == target) {
                array[0] = left + 1;
                array[1] = right + 1;
                break;
            } else if (v > target) {
                right--;
            } else {
                left++;
            }
        }
        return array;
    }
}
