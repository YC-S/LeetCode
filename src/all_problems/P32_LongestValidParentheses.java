package all_problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class P32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        int left = -1;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(') stack.offerFirst(j);
            else {
                if (stack.isEmpty()) left = j;
                else {
                    stack.pollFirst();
                    if (stack.isEmpty()) max = Math.max(max, j - left);
                    else max = Math.max(max, j - stack.peekFirst());
                }
            }
        }
        return max;
    }
}
