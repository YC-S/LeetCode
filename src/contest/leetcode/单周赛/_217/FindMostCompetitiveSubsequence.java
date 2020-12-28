/*
 * Copyright (c) 2020. Yuanchen
 */

package contest.leetcode.单周赛._217;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/28
 */
public class FindMostCompetitiveSubsequence {

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 6};
        System.out.println(Arrays.toString(mostCompetitive(nums, 2)));
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int additionalCount = nums.length - k;
        for (int num : nums) {
            while (!queue.isEmpty() && queue.peekLast() > num && additionalCount > 0) {
                queue.pollLast();
                additionalCount--;
            }
            queue.addLast(num);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.pollFirst();
        }
        return result;
    }
}
