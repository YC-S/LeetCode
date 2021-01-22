package all_problems;

import java.util.Stack;

public class P1081_SmallestSubsequenceOfDistinctCharacters {
    public String smallestSubsequence(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] last = new int[26], seen = new int[26];
        for (int i = 0; i < s.length(); ++i)
            last[s.charAt(i) - 'a'] = i;
        for (int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i) - 'a';
            if (seen[c]++ > 0) continue;
            while (!stack.isEmpty() && stack.peek() > c && i < last[stack.peek()])
                seen[stack.pop()] = 0;
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : stack) sb.append((char) ('a' + i));
        return sb.toString();
    }
}
