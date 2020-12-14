/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/17
 */
public class P46_Permutations {

    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        helper(nums, 0, res);
        return res;
    }

    private void helper(int[] array, int index, List<List<Integer>> res) {
        if (index == array.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : array) {
                tmp.add(num);
            }
            res.add(tmp);
            return;
        }
        for (int i = index; i < array.length; ++i) {
            swap(array, i, index);
            helper(array, index + 1, res);
            swap(array, i, index);
        }
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
