package algoexpert;

import java.util.*;

public class BalancedBrackets {
    public static boolean balancedBrackets(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] arr = str.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Set<Character> set = new HashSet<>();
        set.add('(');
        set.add(')');
        set.add('[');
        set.add(']');
        set.add('{');
        set.add('}');
        for (char c : arr) {
            if (set.contains(c)) {
                if (stack.isEmpty()) {
                    stack.add(c);
                } else {
                    if (map.get(c) == stack.peek()) {
                        stack.pollFirst();
                    } else {
                        stack.offerFirst(c);
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(balancedBrackets("([])"));
    }
}
