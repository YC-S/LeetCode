/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/18
 */
public class P22_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfs(sb, 0, res, n, 0, 0);
        return res;
    }

    private void dfs(StringBuilder sb, int index, List<String> res, int n, int leftCount, int rightCount) {
        if (leftCount == n && rightCount == n) {
            res.add(sb.toString());
            return;
        }
        if (leftCount > n || rightCount > n || leftCount < rightCount) {
            return;
        }
        if (leftCount >= rightCount) {
            dfs(sb.append("("), index + 1, res, n, leftCount + 1, rightCount);
            sb.deleteCharAt(sb.length() - 1);
            dfs(sb.append(")"), index + 1, res, n, leftCount, rightCount + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
