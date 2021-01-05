package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/01
 */
public class P10_RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        //记忆搜索结果
        boolean[][] memo = new boolean[s.length()][p.length()];
        //标记是否访问
        boolean[][] visited = new boolean[s.length()][p.length()];

        return isMatchHelper(s, 0, p, 0, memo, visited);
    }

    private boolean isMatchHelper(String s, int sIndex,
        String p, int pIndex,
        boolean[][] memo,
        boolean[][] visited) {
        // "" == ""
        //如果p已经匹配完毕
        if (pIndex == p.length()) {
            //根据s是否匹配完毕即可
            return sIndex == s.length();
        }
        //如果s匹配完毕
        if (sIndex == s.length()) {
            return isEmpty(p, pIndex);
        }

        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }

        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        boolean match;

        // consider a* as a bundle
        //如果为'*'，有两种方案
        if (pIndex + 1 < p.length()
            && p.charAt(pIndex + 1) == '*') {
            match = isMatchHelper(s, sIndex, p, pIndex + 2, memo, visited) ||
                //'*'不去匹配字符
                //'*'重复前面一个字符去匹配s
                charMatch(sChar, pChar) && isMatchHelper(s, sIndex + 1, p, pIndex, memo,
                    visited);
        } else {
            //如果当前两字符匹配
            //继续下一个字符匹配
            match = charMatch(sChar, pChar) &&
                isMatchHelper(s, sIndex + 1, p, pIndex + 1, memo, visited);
        }

        //搜索完成就标记
        visited[sIndex][pIndex] = true;
        //存储搜索结果
        memo[sIndex][pIndex] = match;
        return match;
    }

    /**
     * 判断两字符是否匹配
     */
    private boolean charMatch(char sChar, char pChar) {
        return sChar == pChar || pChar == '.';
    }

    /**
     * 形如"x*x*"形式
     */
    private boolean isEmpty(String p, int pIndex) {
        for (int i = pIndex; i < p.length(); i += 2) {
            //如果不是'*'，无法匹配
            if (i + 1 >= p.length() || p.charAt(i + 1) != '*') {
                return false;
            }
        }
        return true;
    }
}
