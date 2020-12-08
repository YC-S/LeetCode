/*
 * Copyright (c) 2020. Yuanchen
 */

package contest._b_40;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/29
 */
public class FrontMiddleBackQueue {


    Deque<Integer> dq;

    public FrontMiddleBackQueue() {
        dq = new ArrayDeque<>();
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue fmb = new FrontMiddleBackQueue();
        fmb.pushFront(888438);
        fmb.pushMiddle(772690);
        fmb.pushMiddle(375192);
        fmb.pushFront(885613);
        fmb.pushMiddle(508187);
        System.out.println(fmb.popMiddle());
        System.out.println(fmb.popMiddle());
        fmb.pushMiddle(111498);
        fmb.pushMiddle(296008);
        System.out.println(fmb.popFront());
    }

    public void pushFront(int val) {
        dq.offerFirst(val);
    }

    public void pushMiddle(int val) {
        int n = dq.size();
        Deque<Integer> stack = new ArrayDeque<>();

        int middleIndex = n / 2;
        for (int i = 0; i < middleIndex; ++i) {
            stack.offerLast(dq.pollFirst());
        }
        dq.offerFirst(val);
        for (int i = 0; i < middleIndex; ++i) {
            dq.offerFirst(stack.pollLast());
        }
    }

    public void pushBack(int val) {
        dq.offerLast(val);
    }

    public int popFront() {
        return dq.isEmpty() ? -1 : dq.pollFirst();
    }

    public int popMiddle() {

        int n = dq.size();
        int res = 0;
        if (n == 0) {
            return -1;
        } else {
            if (n % 2 == 0) {
                int middleIndex = n / 2 - 1;
                Deque<Integer> stack = new ArrayDeque<>();
                for (int i = 0; i < middleIndex; ++i) {
                    stack.offerLast(dq.pollFirst());
                }
                res = dq.pollFirst();
                for (int i = 0; i < middleIndex; ++i) {
                    dq.offerFirst(stack.pollLast());
                }
            } else {
                int middleIndex = n / 2;
                Deque<Integer> stack = new ArrayDeque<>();
                for (int i = 0; i < middleIndex; ++i) {
                    stack.offerLast(dq.pollFirst());
                }
                res = dq.pollFirst();
                for (int i = 0; i < middleIndex; ++i) {
                    dq.offerFirst(stack.pollLast());
                }
            }
            return res;
        }
    }

    public int popBack() {
        return dq.isEmpty() ? -1 : dq.pollLast();
    }
}
