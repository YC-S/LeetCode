package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.PriorityQueue;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/10
 */
public class P215_KthLargestElementInArray {

    /**
     *
     */
    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // output
        return heap.poll();
    }
}
