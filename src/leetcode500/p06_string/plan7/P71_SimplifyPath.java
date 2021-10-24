package leetcode500.p06_string.plan7;

import java.util.ArrayDeque;
import java.util.Deque;

public class P71_SimplifyPath {
  public String simplifyPath(String path) {
    Deque<String> stack = new ArrayDeque<>();
    for (String s : path.split("/")) {
      if (s.equals("..")) stack.pollFirst();
      else if (!s.equals("") && !s.equals(".")) stack.offerFirst(s);
    }
    StringBuilder sb = new StringBuilder();
    if (stack.size() == 0) return "/";
    while (stack.size() != 0) sb.append("/").append(stack.pollLast());
    return sb.toString();
  }
}
