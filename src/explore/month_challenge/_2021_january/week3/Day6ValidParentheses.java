package explore.month_challenge._2021_january.week3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Day6ValidParentheses {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        for (char c : arr) {
            if (stack.isEmpty() || !map.containsKey(c)) {
                stack.offerFirst(c);
            } else if (map.get(c) == stack.peekFirst()) {
                stack.pollFirst();
            } else {
                stack.offerFirst(c);
            }
        }
        return stack.isEmpty();
    }
}
