/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/20
 */
public class IsBalanced {

    public static boolean isBalanced(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        if (input == null || input.length() % 2 != 0) {
            return false;
        }
        deque.offerLast(input.charAt(0));
        for (int i = 1; i < input.length(); ++i) {
            char tmp = input.charAt(i);
            if (deque.size() == 0 || !map.containsKey(deque.peekLast())) {
                deque.offerLast(tmp);
                continue;
            }
            if (map.get(deque.peekLast()) == tmp) {
                deque.pollLast();
            } else {
                deque.offerLast(tmp);
            }
        }
        return deque.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("}{"));
    }
}
