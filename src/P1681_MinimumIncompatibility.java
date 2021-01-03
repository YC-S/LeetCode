/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.*;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/05
 */
public class P1681_MinimumIncompatibility {

    static int N;
    static Map<String, Integer> memo;
    static int k;

    private static int dfs(Set<Integer> level, int[] count) {
        if (level.size() == N) {
            return end(count) ? findDiff(level) : findDiff(level) + dfs(new HashSet<>(), count);
        }
        String key = Arrays.hashCode(count) + " "
                + level; //count is remaining element status, level is current hand bucket element
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int res = 1000;
        for (int i = 1; i <= 16; i++) {
            if (count[i] <= 0) {
                continue; //no more this number left
            }
            if (!level.add(i)) {
                continue; //at hand same number already exist
            }
            count[i]--;
            res = Math.min(res, dfs(level, count));
            count[i]++;
            level.remove(i);
            if (level.size() == 0) {
                break;   // first element we don't need to expand
            }
        }
        memo.put(key, res);
        return res;
    }

    private static int findDiff(Set<Integer> level) {
        return Collections.max(level) - Collections.min(level);
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 1, 4};
        int[] nums1 = {6, 3, 8, 1, 3, 1, 2, 2};
        System.out.println(minimumIncompatibility(nums1, 4));
    }

    public static int minimumIncompatibility(int[] nums, int k) {
        Arrays.sort(nums);
        memo = new HashMap<>();
        k = k;
        int[] count = new int[17];
        for (int num : nums) {
            if (++count[num] > k) {
                return -1;  // if same number more than k times, we can not answer the question cause there must be one bucket with same number twice
            }
        }
        N = nums.length / k;   //N is the number of element in each bucket
        return dfs(new HashSet<>(), count);
    }

    private static boolean end(int[] count) {
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
