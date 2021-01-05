package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/10
 */
public class P386_LexicographicalNumbers {

    /**
     * If we build the stack so that the first element is always the smallest, then for every pop operation, we have to
     * simply check if any of the numbers are possible with popped number * 10 + (1 to 9).
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> op = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 9; i >= 1; i--) {
            if (i <= n) {
                stack.offerLast(i);
            }
        }
        while (stack.size() != 0) {
            int cur = stack.pollLast();
            op.add(cur);
            if (cur < n) {
                for (int i = 9; i >= 0; i--) {
                    int next = cur * 10 + i;
                    if (next <= n) {
                        stack.offerLast(next);
                    }
                }
            }
        }
        return op;
    }
}
