/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/10
 */
public class P84_LargestRectangleInHistogram {

    /**
     * Initially, we push a -1 onto the stack to mark the end. We start with the leftmost bar and keep pushing the
     * current bar's index onto the stack until we get two successive numbers in descending order,
     *
     *
     * Time: O(n), n is numbers of pushed and poped Space: O(n), n is the size of stack.
     */
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerLast(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peekLast() != -1 && heights[stack.peekLast()] >= heights[i]) {
                maxarea = Math.max(maxarea, heights[stack.pollLast()] * (i - stack.peekLast() - 1));
            }
            stack.offerLast(i);
        }
        while (stack.peekLast() != -1) {
            maxarea = Math.max(maxarea, heights[stack.pollLast()] * (heights.length - stack.peekLast() - 1));
        }
        return maxarea;
    }
}
