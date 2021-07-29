package laicode.dfsII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllValidPermutationOfParenthesesII {
  private static final char[] PS = new char[] {'(', ')', '<', '>', '{', '}'};

  public static List<String> validParentheses(int l, int m, int n) {
    // Assumptions: l, m, n >= 0.
    int[] remain = new int[] {l, l, m, m, n, n};
    int targetLen = 2 * l + 2 * m + 2 * n;
    StringBuilder sb = new StringBuilder();
    Deque<Character> stack = new ArrayDeque<>();
    List<String> res = new ArrayList<>();
    helper(sb, stack, remain, targetLen, res);
    return res;
  }

  private static void helper(
      StringBuilder sb, Deque<Character> stack, int[] remain, int targetLen, List<String> res) {
    if (sb.length() == targetLen) {
      res.add(sb.toString());
      return;
    }
    for (int i = 0; i < remain.length; i++) {
      if (i % 2 == 0) {
        if (remain[i] > 0) {
          sb.append(PS[i]);
          stack.offerFirst(PS[i]);
          remain[i]--;
          helper(sb, stack, remain, targetLen, res);
          sb.deleteCharAt(sb.length() - 1);
          stack.pollFirst();
          remain[i]++;
        }
      } else {
        if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {
          sb.append(PS[i]);
          stack.pollFirst();
          remain[i]--;
          helper(sb, stack, remain, targetLen, res);
          sb.deleteCharAt(sb.length() - 1);
          stack.offerFirst(PS[i - 1]);
          remain[i]++;
        }
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(validParentheses(3, 0, 0));
  }
}
