/*
 * Copyright (c) 2020. Yuanchen
 */

package contest.leetcode.单周赛._218;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/05
 */
public class GoalParserInterpretation {

    public static String interpret(String command) {
        if (command == null || command.length() == 0) {
            return "";
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < command.length()) {
            if (i + 3 < command.length() && "(al)".equals(command.substring(i, i + 4))) {
                sb.append("al");
                i += 4;
            } else if (i + 1 < command.length() && ("()".equals(command.substring(i, i + 2)))) {
                sb.append("o");
                i += 2;
            } else if (command.charAt(i) == 'G') {
                sb.append('G');
                i += 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));
        System.out.println(interpret("G()()()()(al)"));
        System.out.println(interpret("(al)G(al)()()G"));
    }
}
