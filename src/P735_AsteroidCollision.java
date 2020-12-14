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
public class P735_AsteroidCollision {

    /**
     * Say we have our answer as a stack with rightmost asteroid top, and a new asteroid comes in. If new is moving
     * right (new > 0), or if top is moving left (top < 0), no collision occurs.
     *
     * Otherwise, if abs(new) < abs(top), then the new asteroid will blow up; if abs(new) == abs(top) then both
     * asteroids will blow up; and if abs(new) > abs(top), then the top asteroid will blow up (and possibly more
     * asteroids will, so we should continue checking.)
     *
     * Time Complexity: O(N), where N is the number of asteroids. Space Complexity: O(N), where N is the number of
     * asteroids.
     */

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        if (asteroids.length < 2) {
            return asteroids;
        }
        boolean flag = true;
        for (int size : asteroids) {
            flag = true;
            while (!stack.isEmpty() && stack.peekLast() > 0 && size < 0) {
                if (stack.peekLast() < -size) {
                    stack.pollLast();
                } else if (stack.peekLast() == -size) {
                    stack.pollLast();
                    flag = false;
                    break;
                } else if (stack.peekLast() > -size) {
                    flag = false;
                    break;
                }
            }
            if (flag != false) {
                stack.offerLast(size);
            }
        }

        int[] newArr = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            newArr[i] = stack.pollLast();
        }
        return newArr;
    }
}
