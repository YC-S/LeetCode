/*
 * Copyright (c) 2020. Yuanchen
 */

package 程序员代码面试指南.第1章栈和队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/01
 */
public class MyStack {

    private final Deque<Integer> stackData;
    private final Deque<Integer> stackMin;

    public MyStack() {
        this.stackData = new ArrayDeque<>();
        this.stackMin = new ArrayDeque<>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.offerLast(newNum);
        } else if (newNum <= this.getmin()) {
            this.stackMin.offerLast(newNum);
        }
        this.stackData.offerLast(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        int value = this.stackData.pollLast();
        if (value == this.getmin()) {
            this.stackMin.pop();
        }
        return value;
    }

    public int getmin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return this.stackMin.peekLast();
    }

}
