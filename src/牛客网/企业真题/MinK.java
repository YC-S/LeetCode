/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.企业真题;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/03
 */
public class MinK {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (k > input.length) {
            return res;
        }
        for (int i : input) {
            minHeap.offer(i);
        }
        for (int i = 0; i < k; ++i) {
            res.add(minHeap.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution(input, 4));
    }

}
