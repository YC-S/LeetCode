package explore.month_challenge._2021_february.week1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Day5SimplifyPath {
    public static String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String s : path.split("/")) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (!s.equals("") && !s.equals(".")) {
                stack.offerFirst(s);
            }
        }
        for (String s : stack) {
            sb.append(s).append("/");
        }
        if (!stack.isEmpty()) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
