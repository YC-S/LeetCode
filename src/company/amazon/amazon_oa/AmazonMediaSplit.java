/*
 * Copyright (c) 2020. Yuanchen
 */

package company.amazon.amazon_oa;

import java.util.PriorityQueue;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/03
 */
public class AmazonMediaSplit {

    public static int splitsFile(int[] file) {
//        Time Complexity: O(n*log(n))
//        Space Complexity: O(n)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for (int f : file) {
            pq.add(f);
        }
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + second);
            sum += first + second;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] files = {1, 3, 5, 9, 12};
        System.out.println(splitsFile(files));
    }
}
