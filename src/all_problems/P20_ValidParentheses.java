package all_problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class P20_ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == '(') {
                stack.offerLast(')');
            } else if (array[i] == '[') {
                stack.offerLast(']');
            } else if (array[i] == '{') {
                stack.offerLast('}');
            } else if (!stack.isEmpty() && stack.peekLast() == array[i]) {
                stack.pollLast();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
